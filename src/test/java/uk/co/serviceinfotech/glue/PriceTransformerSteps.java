package uk.co.serviceinfotech.glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java8.En;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriceTransformerSteps implements En {

    private Map<String, Price> priceList;
    private int sekSum;
    private int euroSum;


    public PriceTransformerSteps() {
        ParameterType("color", "red|blue|yellow", Color::new);

        DataTableType((Map<String, String> row) -> {
            String product = row.get("product");
            String currency = row.get("currency");
            Integer price = Integer.parseInt(row.get("price"));
            return new Price(product, price, currency);
        });


        Given("I have a {color} ball", (Color color) -> {
            color.getValue();
        });

        Given("the price list for an international coffee shop", (DataTable dataTable) -> {
            List<Price> prices = dataTable.asList(Price.class);
            priceList = new HashMap();
            for (Price price : prices) {
                String key = price.getProduct();
                priceList.put(key, price);
            }
        });
        When("I buy {int} {word}", (Integer numberOfItems, String item) -> {
            Price price = priceList.get(item);
            calculate(numberOfItems, price);
        });

        Then("should I pay {int} EUR and {int} SEK", (Integer expectedEuroSum, Integer expectedSekSum) -> {
            assertThat(euroSum, is(expectedEuroSum));
            assertThat(sekSum, is(expectedSekSum));
        });

    }

    private void calculate(int numberOfItems, Price price) {
        if (price.getCurrency().equals("SEK")) {
            sekSum += numberOfItems * price.getPrice();
            return;
        }
        if (price.getCurrency().equals("EUR")) {
            euroSum += numberOfItems * price.getPrice();
            return;
        }
        throw new IllegalArgumentException("The currency is unknown");
    }


}
