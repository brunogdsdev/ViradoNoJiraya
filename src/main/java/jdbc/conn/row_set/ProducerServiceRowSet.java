package jdbc.conn.row_set;

import jdbc.conn.Producer;
import jdbc.conn.result_set.ProducerService;

import java.util.List;

public class ProducerServiceRowSet {


    public static List<Producer> findByNameRowSet(String name){
        return ProducerRepositoryRowSet.findByNameRowSet(name);
    }

    public static void updateRowSet(Producer producer){
        ProducerService.requireValidId(producer.getId());
        ProducerRepositoryRowSet.updateRowSet(producer);
    }
}
