package com.blackforestcastle;

import java.io.IOException;
import java.util.Scanner;

class ConsoleUtilities {
    private static final String os = System.getProperty("os.name").toLowerCase();

    public static void clearConsole() {
        ProcessBuilder thisOS = os.contains("windows") ? new ProcessBuilder(new String[]{"cmd", "/c", "cls"}) : new ProcessBuilder(new String[]{"clear"});
        try {
            thisOS.inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void pauseForInput() {
        System.out.println("Press Enter key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearConsole();
    }

    public static void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}