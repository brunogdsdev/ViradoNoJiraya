package jdbc.conn.prepared_statement;

import jdbc.conn.Producer;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryMainPreparedStatement {

    public static void main(String[] args) {

        Producer p = Producer.builder().id(1).name("PREPARED1.A").build();

//        ProducerService.savePreparedStatement(p);
//        ProducerService.updatePreparedStatement(p);
        List<Producer> list = ProducerServicePreparedStatement.findByNamePreparedStatement("P");

        log.info("Producers found {}", list);

    }
}
