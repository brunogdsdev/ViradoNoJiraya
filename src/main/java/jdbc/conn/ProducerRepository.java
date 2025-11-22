package jdbc.conn;

import lombok.extern.log4j.Log4j2;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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


    public static void update(Producer p){
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE id = %d".formatted(p.getName(), p.getId());

        try(
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
        ){

            int i = stmt.executeUpdate(sql);
            log.info("Rows affected '{}'", i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public static List<Producer> findAll(){
        log.info("Finding all");
        String sql = "SELECT id, name FROM anime_store.producer";
        List<Producer> list = new ArrayList<>();

        try(
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ){

            while(rs.next()){
                list.add(
                        Producer
                                .builder()
                                .name(rs.getString("name"))
                                .id(rs.getInt("id"))
                                .build()
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<Producer> findByName(String value){
        String sql = "SELECT * from anime_store.producer WHERE name like '%%s%%'".formatted(value);
        List<Producer> list = new ArrayList<>();
        try(
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){

            while (rs.next()){
                list.add(
                        Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build()
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<Producer> findBy(String column, String value){
        String sql = "SELECT * from anime_store.producer WHERE %s = '%s'".formatted(column, value);
        List<Producer> list = new ArrayList<>();

        log.info(sql);
        try(
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ){

            while (rs.next()){
                list.add(
                  Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build()
                );
            }

            log.info("FINDBY {}", list.get(0).getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }



    public static List<Producer> findByNameAndUpdateToUppercase(String value){
        String sql = "SELECT * from anime_store.producer WHERE name like '%%s%%'".formatted(value);
        List<Producer> list = new ArrayList<>();
        try(
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery(sql);
        ){

            while (rs.next()){

                rs.updateString("name", rs.getString("name").toUpperCase());
//                rs.cancelRowUpdates(); // PARA ROWBACK
                rs.updateRow(); // PARA COMMIT
                list.add(
                        Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build()
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public static List<Producer> findByNameAndInsertIfNotExists(String value){
        String sql = "SELECT * from anime_store.producer WHERE name like '%%s%%'".formatted(value);
        List<Producer> list = new ArrayList<>();
        try(
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery(sql);
        ){

            if(!rs.next()){
                rs.moveToInsertRow(); // MOVE O CURSOR PARA UMA LINHA DE INSERĆAO
                rs.updateString("name", value);
                rs.insertRow(); // COMMIT
                rs.beforeFirst();
                rs.next();
                list.add(
                        Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build()
                );

//                rs.deleteRow(); // DELETE
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }



}
