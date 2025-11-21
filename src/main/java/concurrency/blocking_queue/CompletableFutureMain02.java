package concurrency.blocking_queue;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CompletableFutureMain02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchCompletablePriceASync(storeService);
    }

    private static void searchCompletablePriceASync(StoreService storeService){
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        List<CompletableFuture<Double>> futures = stores.stream()
                .map(storeService::getPriceAsyncCompletableFuture)
                .toList();

        List<Double> prices = futures.stream().map(CompletableFuture::join).toList();



        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }
}
