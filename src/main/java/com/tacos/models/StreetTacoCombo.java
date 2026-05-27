package com.tacos.models;

public class StreetTacoCombo extends ComboOrder {

    public StreetTacoCombo() {

        comboName = "Street Taco Combo";

        tacos.add(new StreetTaco());
        tacos.add(new StreetTaco());
        tacos.add(new StreetTaco());

        Drink drink = new Drink("Medium", "Horchata");

        drinks.add(drink);
    }
}