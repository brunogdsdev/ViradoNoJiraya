package jdbc.conn.transaction;

import jdbc.conn.Producer;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ConnectionFactoryMainTransaction {

    public static void main(String[] args) {

        Producer p1 = Producer.builder().id(1).name("HAJIME NO IPPO").build();
        Producer p2 = Producer.builder().id(1).name("SLAM DUNK").build();
        Producer p3 = Producer.builder().id(1).name("NARUTO").build();
        Producer p4 = Producer.builder().id(1).name("BORUTO").build();


        List<Producer> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        ProducerServiceTransaction.saveTransaction(list);

        log.info("Producers added {}", list);

    }
}
