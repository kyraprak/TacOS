// lightweight combo meal containing a taco and chips & salsa
package com.tacos.models;

public class TacoSnackCombo extends ComboOrder {

    public TacoSnackCombo() {

        comboName = "Taco Snack Combo";

        Taco taco = new Taco();

        taco.setSize(com.tacos.enums.TacoSize.SINGLE);

        taco.setShell(com.tacos.enums.ShellType.FLOUR);

        taco.getMeats().add("Pollo");

        taco.getCheeses().add("Cheddar");

        taco.getToppings().add("Lettuce");

        tacos.add(taco);

        chips.add(new ChipsAndGuac("Lime Guacamole"));
    }
}