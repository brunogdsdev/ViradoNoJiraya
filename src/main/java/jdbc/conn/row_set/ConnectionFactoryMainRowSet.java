package jdbc.conn.row_set;

import jdbc.conn.Producer;
import lombok.extern.log4j.Log4j2;

import java.util.List;


@Log4j2
public class ConnectionFactoryMainRowSet {
    public static void main(String[] args) {
        Producer p = Producer.builder().id(1).name("123456").build();
        List<Producer> list = ProducerServiceRowSet.findByNameRowSet("");
        ProducerServiceRowSet.updateRowSet(p);

        log.info(list);
        for(Producer producer : list){
            log.info("id: {}, Nome: '{}' \n", producer.getId(), producer.getName());
        }


    }
}
