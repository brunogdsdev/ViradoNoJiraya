package jdbc.conn;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@Log4j2
public class ProducerRepository {
    public static void save(Producer p) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUE ('%s');".formatted(p.getName());

        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
        ) {

            int rows = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rows);

        } catch (SQLException e) {
            log.error("Error to insert '{}'", p.getName(), e);
        }
    }


    public static void delete(Integer id){
        String sql = "DELETE FROM `anime_store`.producer WHERE `producer`.`id` = '%d' ".formatted(id);

        try(Connection con = ConnectionFactory.getConnection();
            Statement stmt = con.createStatement()
        ){
            int i = stmt.executeUpdate(sql);
            log.info("Delete finished with '{}'", i);
        }catch (SQLException e){
            log.error("Error on delete '{}'", id, e);
        }
    }
}
