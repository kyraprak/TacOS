package com.tacos.models;

import java.util.ArrayList;
import java.util.List;

// represents a customer's complete order including individual items and combos
public class Order {

    private List<Taco> tacos;
    private List<Drink> drinks;
    private List<ChipsAndGuac> chips;
    private List<ComboOrder> combos;

    public Order() {

        tacos = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        combos = new ArrayList<>();
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<ChipsAndGuac> getChips() {
        return chips;
    }

    public List<ComboOrder> getCombos() {
        return combos;
    }
    // centralized order pricing calculation used during checkout
    public double calculateTotal() {

        double total = 0;

        for (Taco taco : tacos) {
            total += taco.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.calculatePrice();
        }

        for (ChipsAndGuac chips : chips) {
            total += chips.calculatePrice();
        }

        for (ComboOrder combo : combos) {
            total += combo.calculatePrice();
        }

        return total;
    }
}