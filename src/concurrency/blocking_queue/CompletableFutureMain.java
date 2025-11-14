package concurrency.blocking_queue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureMain {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
//        searchPriceSync(storeService);
//        searchPriceASync(storeService);
        searchCompletablePriceASync(storeService);
    }

    private static void searchPriceSync(StoreService storeService){
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync()+ " Store 1");
        System.out.println(storeService.getPriceSync()+ " Store 2");
        System.out.println(storeService.getPriceSync()+ " Store 3");
        System.out.println(storeService.getPriceSync()+ " Store 4");
        System.out.println(storeService.getPriceSync()+ " Store 5");
        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }
    private static void searchPriceASync(StoreService storeService){
        long start = System.currentTimeMillis();
        Future<Double> service1 = storeService.getPriceAsyncFuture(" Store 1");
        Future<Double> service2 = storeService.getPriceAsyncFuture(" Store 2");
        Future<Double> service3 = storeService.getPriceAsyncFuture(" Store 3");
        Future<Double> service4 = storeService.getPriceAsyncFuture(" Store 4");
        Future<Double> service5 = storeService.getPriceAsyncFuture(" Store 5");
        try {
            System.out.println(service1.get());
            System.out.println(service2.get());
            System.out.println(service3.get());
            System.out.println(service4.get());
            System.out.println(service5.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));

        StoreService.shutdown();
    }

    private static void searchCompletablePriceASync(StoreService storeService){
        long start = System.currentTimeMillis();
        CompletableFuture<Double> service1 = storeService.getPriceAsyncCompletableFuture(" Store 1");
        CompletableFuture<Double> service2 = storeService.getPriceAsyncCompletableFuture(" Store 2");
        CompletableFuture<Double> service3 = storeService.getPriceAsyncCompletableFuture(" Store 3");
        CompletableFuture<Double> service4 = storeService.getPriceAsyncCompletableFuture(" Store 4");
        CompletableFuture<Double> service5 = storeService.getPriceAsyncCompletableFuture(" Store 5");
//        try {
//            System.out.println(service1.get());
//            System.out.println(service2.get());
//            System.out.println(service3.get());
//            System.out.println(service4.get());
//            System.out.println(service5.get());
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(service1.join());
        System.out.println(service2.join());
        System.out.println(service3.join());
        System.out.println(service4.join());
        System.out.println(service5.join());
        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }
}
