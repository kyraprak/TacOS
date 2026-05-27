package com.tacos.models;

import com.tacos.interfaces.Pricable;
import com.tacos.interfaces.Receiptable;

public class ChipsAndGuac implements Pricable, Receiptable {

    private String salsaType;

    public ChipsAndGuac(String salsaType) {
        this.salsaType = salsaType;
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }

    @Override
    public String getReceiptText() {

        return """
                Chips & Salsa:
                Salsa Type: %s
                Price: $%.2f
                """.formatted(salsaType, calculatePrice());
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}
