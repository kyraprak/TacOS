package com.tacos.models;

import com.tacos.interfaces.Pricable;
import com.tacos.interfaces.Receiptable;

public class Drink implements Pricable, Receiptable {

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice() {

        return switch (size.toLowerCase()) {

            case "small" -> 2.00;
            case "medium" -> 5.50;
            case "large" -> 8.00;
            default -> 0;
        };
    }

    @Override
    public String getReceiptText() {

        return """
                Drink:
                Size: %s
                Flavor: %s
                Price: $%.2f
                """.formatted(size, flavor, calculatePrice());
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}