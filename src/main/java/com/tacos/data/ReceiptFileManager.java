package com.tacos.data;

import java.io.File;

public class ReceiptFileManager {

    public static void createReceiptFolder() {

        File folder = new File("receipts");

        if (!folder.exists()) {
            folder.mkdir();
        }
    }
}
