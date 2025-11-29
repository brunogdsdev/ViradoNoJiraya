package jdbc.conn.transaction;

import jdbc.conn.ConnectionFactory;
import jdbc.conn.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.List;


@Log4j2
public class ProducerRepositoryTransaction {

    public static void saveTransaction(List<Producer> pList) {

        try (Connection con = ConnectionFactory.getConnection()) {
            con.setAutoCommit(false);
            preparedStatementSaveTransaction(con, pList);
            log.info("TRANSACTION:Database rows");


            con.commit(); // vai ser executado quando terminar
            con.setAutoCommit(true); // se nao virar de volta pra true,  em outras chamadas ele já irá iniciar com false o autoCommit
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producerList) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";

        boolean shouldRollback = false;
        for(Producer producer : producerList){

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                log.info("Saving producer {}", producer.getName());
                ps.setString(1, producer.getName());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollback = true;
            }
        }


        if(shouldRollback){
            conn.rollback();
        }
    }
}
