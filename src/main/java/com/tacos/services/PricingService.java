package com.tacos.services;

import com.tacos.models.*;

public class PricingService {

    public double calculateOrderTotal(Order order) {

        double total = 0;

        for (Taco taco : order.getTacos()) {
            total += taco.calculatePrice();
        }

        for (Drink drink : order.getDrinks()) {
            total += drink.calculatePrice();
        }

        for (ChipsAndGuac chips : order.getChips()) {
            total += chips.calculatePrice();
        }

        return total;
    }
}
