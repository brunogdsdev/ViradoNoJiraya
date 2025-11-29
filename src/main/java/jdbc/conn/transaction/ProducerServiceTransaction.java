package jdbc.conn.transaction;

import jdbc.conn.Producer;

import java.util.List;

public class ProducerServiceTransaction {

    public static void saveTransaction(List<Producer> producers){
        ProducerRepositoryTransaction.saveTransaction(producers);
    }


}
