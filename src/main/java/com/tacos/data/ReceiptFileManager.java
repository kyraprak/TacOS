// creates the receipts directory if it does not already exist.
// all completed order receipts are stored here.
package com.tacos.data;

import java.io.File;

public class ReceiptFileManager {

    private static final String RECEIPT_FOLDER = "receipts";

    public static void createReceiptFolder() {

        File folder = new File(RECEIPT_FOLDER);

        if (!folder.exists()) {

            boolean created = folder.mkdir();

            if (created) {
                System.out.println("Receipts folder created.");
            }
        }
    }
}
