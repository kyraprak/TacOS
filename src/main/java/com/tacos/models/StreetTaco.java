// signature taco preset using inheritance from the Taco base class
package com.tacos.models;

import com.tacos.enums.ShellType;
import com.tacos.enums.TacoSize;

public class StreetTaco extends Taco {

    public StreetTaco() {

        this.size = TacoSize.THREE_TACO;
        this.shell = ShellType.CORN;

        meats.add("Carne Asada");

        toppings.add("Onions");
        toppings.add("Cilantro");

        sauces.add("Salsa Verde");
    }
}