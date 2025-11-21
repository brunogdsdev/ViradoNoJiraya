package jdbc.conn;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryMain {

    public static void main(String[] args) {
//        ConnectionFactory.getConnection().close();

//        Producer p = Producer.ProducerBuilder.builder().name("Naruto").build();
//        ProducerRepository.save(p);

        log.info("TESTE INFO");
        Producer p = Producer.builder().name("Teste").build();
//        ProducerService.save(p);
//        ProducerService.delete(2);


    }
}
