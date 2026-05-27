package com.tacos.models;

import com.tacos.enums.ShellType;
import com.tacos.enums.TacoSize;

public class SuperBurrito extends Taco {

    public SuperBurrito() {

        this.size = TacoSize.BURRITO;
        this.shell = ShellType.FLOUR;

        meats.add("Carnitas");

        cheeses.add("Cheddar");

        toppings.add("Pico de Gallo");
        toppings.add("Lettuce");
        toppings.add("Tomatoes");
        toppings.add("Cilantro");
        toppings.add("Onion");

        covered = true;
    }
}
