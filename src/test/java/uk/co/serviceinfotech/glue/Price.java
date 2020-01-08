package uk.co.serviceinfotech.glue;

public class Price {
    private final String product;
    private final Integer price;
    private final String currency;

    public Price(String product, Integer price, String currency) {

        this.product = product;
        this.price = price;
        this.currency = currency;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
