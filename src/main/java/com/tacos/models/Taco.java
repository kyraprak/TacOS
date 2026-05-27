package com.tacos.models;

import java.util.ArrayList;
import java.util.List;

public class Taco {

    private String size;
    private String shell;

    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;

    private boolean extraMeat;
    private boolean extraCheese;
    private boolean covered;

    public Taco() {
        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
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
    public String toString() {
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
                """.formatted(
                size,
                shell,
                meats,
                cheeses,
                toppings,
                sauces,
                extraMeat ? "Yes" : "No",
                extraCheese ? "Yes" : "No",
                covered ? "Yes" : "No"
        );
    }
}
