// service layer responsible for business logic
package com.tacos.services;

import com.tacos.models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// handles receipt file generation and persistence
// saves completed order details into a timestamped receipt file
// uses current date/time to ensure unique receipt filenames
public class ReceiptService {

    private static int orderCounter = 1000;

    public void saveReceipt(Order order, double total) {

        int orderNumber = orderCounter++;

        String fileName = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"))
                + ".txt";

        try (FileWriter writer = new FileWriter("receipts/" + fileName)) {

            writer.write("""
                =============================
                     TACOVERSE RECEIPT
                =============================
        """);

            writer.write("ORDER #: " + orderNumber + "\n\n");

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

            System.out.println("Receipt successfully saved!");

        } catch (IOException e) {

            System.out.println("Error saving receipt.");
        }
    }
}
