package jdbc.conn.prepared_statement;

import jdbc.conn.ConnectionFactory;
import jdbc.conn.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Log4j2
public class ProducerRepositoryPreparedStatement {


    // !TRANSACTION EXAMPLE --->
    public static void saveTransaction(List<Producer> pList) {

        try (Connection con = ConnectionFactory.getConnection()) {
            con.setAutoCommit(false);
            preparedStatementSaveTransaction(con, pList);
            log.info("TRANSACTION:Database rows affected {}");

        } catch (SQLException e) {
            log.error("TRANSACTION:Error to insert");
        }
    }

    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producerList) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";

        for(Producer producer : producerList){

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                log.info("Saving producer {}", producer.getName());
                ps.setString(1, producer.getName());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
// << ---- !TRANSACTION EXAMPLE











    public static void savePreparedStatement(Producer p) {


        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = savePreparedStatement(con, p);
        ) {

            int rows = ps.executeUpdate();
            log.info("Database rows affected {}", rows);

        } catch (SQLException e) {
            log.error("Error to insert '{}'", p.getName(), e);
        }
    }





    private static PreparedStatement savePreparedStatement(Connection conn, Producer producer) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUE (?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        return ps;
    }



    public static List<Producer> findByNamePreparedStatement(String value){
        List<Producer> list = new ArrayList<>();
        try(
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement ps = preparedStatementFindByName(con, value);
                ResultSet rs = ps.executeQuery()
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
    private static PreparedStatement preparedStatementFindByName(Connection conn, String value) throws SQLException {
        String sql = "SELECT * from anime_store.producer WHERE name like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", value));
        return ps;
    }









    public static void updatePreparedStatement(Producer p){
        try(
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement ps = preparedStatementUpdate(con, p);
        ){

            int i = ps.executeUpdate();
            log.info("Rows affected '{}'", i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,producer.getName());
        ps.setInt(2,producer.getId());
        return  ps;
    }

}
