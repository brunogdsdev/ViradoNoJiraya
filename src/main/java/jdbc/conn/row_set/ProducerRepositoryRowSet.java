package jdbc.conn.row_set;

import jdbc.conn.ConnectionFactory;
import jdbc.conn.Producer;
import jdbc.conn.row_set.listener.CustomRowSetListener;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameRowSet(String name){
        String sql = "SELECT * from anime_store.producer WHERE name like ?;";

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
        String sql = "SELECT * FROM `anime_store`.`producer` WHERE id = ?";

        try(JdbcRowSet jrs = ConnectionFactory.getConnectionRowSet()){

            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if((!jrs.next())) return;

            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
