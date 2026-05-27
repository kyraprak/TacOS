// entry point for launching the TacoVerse application flow
package com.tacos.app;

import com.tacos.data.ReceiptFileManager;
import com.tacos.ui.UserInterface;

public class App {

    public void run() {

        ReceiptFileManager.createReceiptFolder();

        UserInterface ui = new UserInterface();

        ui.display();
    }
}
