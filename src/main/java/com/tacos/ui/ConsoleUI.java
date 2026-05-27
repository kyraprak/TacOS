package com.tacos.ui;

import static com.tacos.ui.ConsoleColors.*;

public class ConsoleUI {

    public static void success(String message) {
        System.out.println(GREEN + message + RESET);
    }

    public static void error(String message) {
        System.out.println(RED + message + RESET);
    }

    public static void warning(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    public static void title(String message) {
        System.out.println(BOLD_CYAN + message + RESET);
    }

    public static void line(String message) {
        System.out.println(message);
    }

    public static void divider() {
        System.out.println("====================================");
    }

    public static void blank() {
        System.out.println();
    }
}