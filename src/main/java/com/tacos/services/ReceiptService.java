package com.tacos.services;

import com.tacos.models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptService {

    public void saveReceipt(Order order, double total) {

        String fileName = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"))
                + ".txt";

        try {

            FileWriter writer = new FileWriter("receipts/" + fileName);

            writer.write("""
                    =============================
                         TACOVERSE RECEIPT
                    =============================
                    
                    """);

            for (Taco taco : order.getTacos()) {

                writer.write(taco.getReceiptText());
                writer.write("\n");
            }

            for (Drink drink : order.getDrinks()) {

                writer.write(drink.getReceiptText());
                writer.write("\n");
            }

            for (ChipsAndGuac chips : order.getChips()) {

                writer.write(chips.getReceiptText());
                writer.write("\n");
            }

            for (ComboOrder combo : order.getCombos()) {

                writer.write(combo.getReceiptText());
                writer.write("\n");
            }

            writer.write(String.format("""
                    
                    =============================
                    FINAL TOTAL: $%.2f
                    =============================
                    """, total));

            writer.close();

            System.out.println("Receipt successfully saved!");

        } catch (IOException e) {

            System.out.println("Error saving receipt.");
        }
    }
}
