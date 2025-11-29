package jdbc.conn.cached_row_set;

import jdbc.conn.Producer;
import jdbc.conn.result_set.ProducerService;

import java.util.List;

public class ProducerServiceCachedRowSet {


    public static List<Producer> findByNameRowSet(String name){
        return ProducerRepositoryCachedRowSet.findByNameRowSet(name);
    }

    public static void updateRowSet(Producer producer){
        ProducerService.requireValidId(producer.getId());
        ProducerRepositoryCachedRowSet.updateRowSet(producer);
    }
}
