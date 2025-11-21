package concurrency.blocking_queue;

public final class Quote {

    private final String store;
    private final double price;
    private final Discount.Code discountCode;


    private Quote(String store, double price, Discount.Code discountCode) {
        this.store = store;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     *
     * Creates new Quote object from the value following the pattern storeName:price:discountCode
     *
     * @param value containing storeName:price:dicountCode
     * @return new Quote values from @param value
     */
    public static Quote newQuote(String value){
        String[] split = value.split(":");
        double price = Double.parseDouble(split[1].replace(",", "."));
        return new Quote(split[0], price, Discount.Code.valueOf(split[2]));
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "store='" + store + '\'' +
                ", price=" + price +
                ", discountCode=" + discountCode +
                '}';
    }
}
