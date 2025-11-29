package jdbc.conn.result_set;

import jdbc.conn.Producer;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryMain {

    public static void main(String[] args) {
//        ConnectionFactory.getConnection().close();

//        Producer p = Producer.ProducerBuilder.builder().name("Naruto").build();
//        ProducerRepository.save(p);

        Producer p = Producer.builder().id(1).name("PREPARED1.A").build();
//        ProducerService.save(p);
//        ProducerService.update(p);
//        ProducerService.delete(2);


//        List<Producer> list = ProducerService.findAll();
//        List<Producer> list = ProducerService.findByName("Tes");
//        List<Producer> list = ProducerService.findByNameAndInsertIfNotExists("BORUTO");
        List<Producer> list = ProducerService.findByNameAndUpdateToUppercase("Tes");
//        List<Producer> list = ProducerService.findBy("name","Teste");

        for(Producer producer : list){
            log.info("id: {}, Nome: '{}' \n", producer.getId(), producer.getName());
        }


    }
}
