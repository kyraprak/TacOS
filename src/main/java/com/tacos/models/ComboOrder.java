// base combo meal model that groups tacos, drinks, and sides together
package com.tacos.models;

import com.tacos.interfaces.Pricable;
import com.tacos.interfaces.Receiptable;

import java.util.ArrayList;
import java.util.List;

public class ComboOrder implements Pricable, Receiptable {

    protected String comboName;

    protected List<Taco> tacos;
    protected List<Drink> drinks;
    protected List<ChipsAndGuac> chips;

    public ComboOrder() {

        tacos = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
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

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    // calculates total combo cost by summing all included items
    @Override
    public double calculatePrice() {

        double total = 0;

        for (Taco taco : tacos) {
            total += taco.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.calculatePrice();
        }

        for (ChipsAndGuac chip : chips) {
            total += chip.calculatePrice();
        }

        return total;
    }

    @Override
    public String getReceiptText() {

        StringBuilder builder = new StringBuilder();

        builder.append("\n===== ")
                .append(comboName)
                .append(" =====\n");

        for (Taco taco : tacos) {
            builder.append(taco.getReceiptText()).append("\n");
        }

        for (Drink drink : drinks) {
            builder.append(drink.getReceiptText()).append("\n");
        }

        for (ChipsAndGuac chip : chips) {
            builder.append(chip.getReceiptText()).append("\n");
        }

        builder.append(String.format("Combo Total: $%.2f%n",
                calculatePrice()));

        return builder.toString();
    }
}
