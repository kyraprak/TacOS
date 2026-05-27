package com.tacos.models;

import java.util.ArrayList;
import java.util.List;

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
}