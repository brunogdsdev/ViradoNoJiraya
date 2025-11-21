package concurrency.blocking_queue;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureMain05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount storeService = new StoreServiceWithDiscount();

        searchPriceWithDiscountAsync(storeService);
    }





    private static void searchPriceWithDiscountAsync(StoreServiceWithDiscount storeService){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quot -> CompletableFuture.supplyAsync(() -> storeService.applyDiscount(quot))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);


//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures);

        voidCompletableFuture.join();
        System.out.printf("Finished? %b%n", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }




}
