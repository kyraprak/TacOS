// base taco model used for fully customizable tacos and inherited signature tacos
package com.tacos.models;

import com.tacos.enums.ShellType;
import com.tacos.enums.TacoSize;
import com.tacos.interfaces.Pricable;
import com.tacos.interfaces.Receiptable;

import java.util.ArrayList;
import java.util.List;

public class Taco implements Pricable, Receiptable {

    protected TacoSize size;
    protected ShellType shell;

    protected List<String> meats;
    protected List<String> cheeses;
    protected List<String> toppings;
    protected List<String> sauces;

    protected boolean extraMeat;
    protected boolean extraCheese;
    protected boolean covered;

    public Taco() {

        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
    }

    public TacoSize getSize() {
        return size;
    }

    public void setSize(TacoSize size) {
        this.size = size;
    }

    public ShellType getShell() {
        return shell;
    }

    public void setShell(ShellType shell) {
        this.shell = shell;
    }

    public List<String> getMeats() {
        return meats;
    }

    public List<String> getCheeses() {
        return cheeses;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    // pricing changes dynamically based on taco size,
    // premium toppings, and extra topping selections
    @Override
    public double calculatePrice() {

        double total = switch (size) {

            case SINGLE -> 3.50;
            case THREE_TACO -> 9.00;
            case BURRITO -> 8.50;
        };

        if (!meats.isEmpty()) {

            total += switch (size) {

                case SINGLE -> 1.00;
                case THREE_TACO -> 2.00;
                case BURRITO -> 3.00;
            };
        }

        if (!cheeses.isEmpty()) {

            total += switch (size) {

                case SINGLE -> 0.75;
                case THREE_TACO -> 1.50;
                case BURRITO -> 2.25;
            };
        }

        if (extraMeat) {

            total += switch (size) {

                case SINGLE -> 0.50;
                case THREE_TACO -> 1.00;
                case BURRITO -> 1.50;
            };
        }

        if (extraCheese) {

            total += switch (size) {

                case SINGLE -> 0.30;
                case THREE_TACO -> 0.60;
                case BURRITO -> 0.90;
            };
        }

        return total;
    }
    // generates formatted receipt output for checkout and file saving
    @Override
    public String getReceiptText() {

        return """
                Taco:
                Size: %s
                Shell: %s
                Meats: %s
                Cheeses: %s
                Toppings: %s
                Sauces: %s
                Extra Meat: %s
                Extra Cheese: %s
                Covered: %s
                Price: $%.2f
                """.formatted(
                size,
                shell,
                meats,
                cheeses,
                toppings,
                sauces,
                extraMeat ? "Yes" : "No",
                extraCheese ? "Yes" : "No",
                covered ? "Yes" : "No",
                calculatePrice()
        );
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}