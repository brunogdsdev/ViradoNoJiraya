package concurrency.blocking_queue;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeService = new StoreServiceDeprecated();
        searchCompletablePriceASync(storeService);
    }

    private static void searchCompletablePriceASync(StoreServiceDeprecated storeService){
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(10, r -> {
           Thread t = new Thread(r);
           t.setDaemon(true);
           return t;
        });


        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

//        List<CompletableFuture<Double>> list = stores.stream().map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s))).toList();
        List<CompletableFuture<Double>> list = stores.stream().map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s), executor)).toList();

        List<Double> doubles = list.stream().map(CompletableFuture::join).toList();

        System.out.println(doubles);


        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }
}
