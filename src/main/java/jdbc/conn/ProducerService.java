package jdbc.conn;

import java.util.List;

public class ProducerService {
    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }


    public static void delete(Integer id){
        requireValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer p){
        requireValidId(p.getId());
        ProducerRepository.update(p);
    }


    public static List<Producer> findAll(){
        return ProducerRepository.findAll();
    }

    public static List<Producer> findBy(String column, String value){
        requireValidColumn(column);
        return ProducerRepository.findBy(column, value);
    }

    public static List<Producer> findByName(String value){
        return ProducerRepository.findByName(value);
    }

    public static List<Producer> findByNameAndUpdateToUppercase(String value){
        return ProducerRepository.findByNameAndUpdateToUppercase(value);
    }

    public static List<Producer> findByNameAndInsertIfNotExists(String value){
        return ProducerRepository.findByNameAndInsertIfNotExists(value);
    }

    public static void requireValidColumn(String column){
        if(!column.equals("id") && !column.equals("name")){
            throw new IllegalArgumentException("Invalid column value");
        }
    }

    public static void requireValidId(Integer id){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid id value");
        }
    }

    public static void requireValidName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Invalid id value");
        }
    }

}
