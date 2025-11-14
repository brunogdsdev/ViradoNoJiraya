package concurrency.blocking_queue;

import java.util.concurrent.*;

public class StoreService {

    private static final ExecutorService ex = Executors.newCachedThreadPool();

    public double getPriceSync(){
        return priceGen();
    }

    public Future<Double> getPriceAsyncFuture(String storeName){
        System.out.printf("Capturando prećo %s%n", storeName);

        Future<Double> submit = ex.submit(this::priceGen);
        return submit;
    }

    public CompletableFuture<Double> getPriceAsyncCompletableFuture(String storeName){
        System.out.printf("Capturando prećo %s%n", storeName);
        return CompletableFuture.supplyAsync(this::priceGen);
    }

    public static void shutdown(){
        ex.shutdown();
    }

    private double priceGen(){
        System.out.printf("%s gerando prećo %n", Thread.currentThread().getName());
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
