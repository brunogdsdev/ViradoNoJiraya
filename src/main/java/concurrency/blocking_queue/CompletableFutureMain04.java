package concurrency.blocking_queue;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount storeService = new StoreServiceWithDiscount();
        searchPriceWithDiscount(storeService);
//        searchPriceWithDiscountAsync(storeService);
    }





    private static void searchPriceWithDiscountAsync(StoreServiceWithDiscount storeService){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        List<CompletableFuture<String>> list = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quot -> CompletableFuture.supplyAsync(() -> storeService.applyDiscount(quot))))
                .toList();


        list.stream().map(CompletableFuture::join).forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }






    private static void searchPriceWithDiscount(StoreServiceWithDiscount storeService){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        //        stores.forEach(s -> System.out.println(storeService.getPriceSync(s)));
        stores.stream().map(storeService::getPriceSync).map(Quote::newQuote).map(storeService::applyDiscount).forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.printf("Finished in %d%n", (end - start));
    }
}
