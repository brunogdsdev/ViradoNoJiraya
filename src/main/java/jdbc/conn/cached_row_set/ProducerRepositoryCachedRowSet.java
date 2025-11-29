package jdbc.conn.cached_row_set;

import jdbc.conn.ConnectionFactory;
import jdbc.conn.Producer;
import jdbc.conn.row_set.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerRepositoryCachedRowSet {

    public static List<Producer> findByNameRowSet(String name){
        String sql = "SELECT * from producer WHERE name like ?;";

        List<Producer> list = new ArrayList<>();
        try(JdbcRowSet jrs = ConnectionFactory.getConnectionRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));
            jrs.execute();

            while (jrs.next()){
                Producer producer = Producer.builder()
                        .id(jrs.getInt("id"))
                        .name(jrs.getString("name"))
                        .build();
                list.add(producer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }



    public static void updateRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE id = ?";

        try(CachedRowSet crs = ConnectionFactory.getConnectionCachedRowSet();
            Connection conn = ConnectionFactory.getConnection()){

            conn.setAutoCommit(false);
//            crs.addRowSetListener(new CustomRowSetListener());


            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(conn);
            if((!crs.next())) return;

            crs.updateString("name", producer.getName());
            crs.updateRow();

            // EXISTE POSSIBILIDADE DE TER CONFLITO POR USAR CACHED
            crs.acceptChanges();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
