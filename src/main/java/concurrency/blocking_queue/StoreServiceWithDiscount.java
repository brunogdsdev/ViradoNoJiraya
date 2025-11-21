package concurrency.blocking_queue;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {

    public String getPriceSync(String name){
        System.out.printf("capturando preco para %s%n", name);
        Double price = priceGen();
        Discount.Code code = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price,code);
    }

    private double priceGen(){
        System.out.printf("%s gerando prećo %n ", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) *10;
    }

    public String applyDiscount(Quote quote){
        delay();
        double discount = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage() / 100);
        return String.format("'%s' original price: %.2f. Applying discount code %s. Final price %.2f ",
                quote.getStore(), quote.getPrice(), quote.getDiscountCode(), discount);
    }

    private void delay(){
        try {
            int milli = ThreadLocalRandom.current().nextInt(200,2500);

            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
