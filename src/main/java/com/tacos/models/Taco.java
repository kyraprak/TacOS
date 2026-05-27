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

    @Override
    public double calculatePrice() {

        double basePrice = switch (size) {

            case SINGLE -> 3.50;
            case THREE_TACO -> 9.00;
            case BURRITO -> 8.50;
        };

        double meatPrice = switch (size) {

            case SINGLE -> 1.00;
            case THREE_TACO -> 2.00;
            case BURRITO -> 3.00;
        };

        double cheesePrice = switch (size) {

            case SINGLE -> .75;
            case THREE_TACO -> 1.50;
            case BURRITO -> 2.25;
        };

        if (extraMeat) {
            basePrice += meatPrice / 2;
        }

        if (extraCheese) {
            basePrice += cheesePrice / 2;
        }

        return basePrice + meatPrice + cheesePrice;
    }

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
                Covered: %s
                Price: $%.2f
                """.formatted(
                size,
                shell,
                meats,
                cheeses,
                toppings,
                sauces,
                covered ? "Yes" : "No",
                calculatePrice()
        );
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}