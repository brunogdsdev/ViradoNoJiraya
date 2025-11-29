package crud.repository;

import crud.dominio.Producer;
import crud.service.ProducerService;
import jdbc.conn.ConnectionFactory;
import crud.dominio.Anime;
import jdbc.conn.row_set.listener.CustomRowSetListener;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnimeRepository {


    public static void saveAnime(Anime a, int producer_id){
        String sql = "INSERT INTO anime (name, episodes, producer_id) VALUES (?,?,?)";

        try(Connection conn =  ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){

            if(producer_id > 0){
                System.out.println("CRIADO PRODUCER"+ producer_id) ;
                ps.setString(1, a.getName());
                ps.setInt(2, a.getEpisodes());
                ps.setInt(3, producer_id);
                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static List<Anime> findByName(String name){
        String sql = """
                SELECT 
                     a.*, p.name as p_name, p.id as p_id
                FROM 
                    anime a 
                LEFT JOIN
                    producer p ON p.id = a.producer_id
                WHERE 
                    a.name like ?
        """;

        List<Anime> list = new ArrayList<>();
        try(JdbcRowSet jrs = ConnectionFactory.getConnectionRowSet()) {
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%",name));
            jrs.execute();

            while(jrs.next()){
                Producer p = Producer.builder()
                        .name(jrs.getString("p_name"))
                        .id(jrs.getInt("p_id"))
                        .build();
                list.add(
                        Anime.builder()
                                .id(jrs.getInt("id"))
                                .episodes(jrs.getInt("episoder"))
                                .name(jrs.getString("name"))
                                .producer(p)
                                .build()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
