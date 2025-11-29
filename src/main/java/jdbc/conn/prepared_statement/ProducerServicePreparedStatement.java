package jdbc.conn.prepared_statement;

import jdbc.conn.Producer;

import java.util.List;

public class ProducerServicePreparedStatement {

    public static void saveTransaction(List<Producer> producers){
        ProducerRepositoryPreparedStatement.saveTransaction(producers);
    }

    public static void savePreparedStatement(Producer producer){
        ProducerRepositoryPreparedStatement.savePreparedStatement(producer);
    }

    public static void updatePreparedStatement(Producer p){
        requireValidId(p.getId());
        ProducerRepositoryPreparedStatement.updatePreparedStatement(p);
    }


    public static List<Producer> findByNamePreparedStatement(String value){
        return ProducerRepositoryPreparedStatement.findByNamePreparedStatement(value);
    }

    public static void requireValidId(Integer id){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid id value");
        }
    }

}
