package jdbc.conn;

public class ProducerService {
    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }


    public static void delete(Integer id){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid id value");
        }
        ProducerRepository.delete(id);
    }
}
