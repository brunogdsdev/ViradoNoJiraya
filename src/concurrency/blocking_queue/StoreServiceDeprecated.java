package concurrency.blocking_queue;

import java.util.concurrent.*;

public class StoreServiceDeprecated {

    public double getPriceSync(String name){
        System.out.printf("capturando preco para %s%n", name);
        return priceGen();
    }

    private double priceGen(){
        System.out.printf("%s gerando prećo %n ", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) *10;
    }

    private void delay(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
