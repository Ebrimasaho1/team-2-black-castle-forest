package com.blackforestcastle;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Controller {
    private boolean gameRunning;

    private static Controller controller_instance = null;
    JSONReader jsonReader = new JSONReader();

    private Controller() {
        gameRunning = true;
    }

    public static Controller getInstance() {
        if (controller_instance == null) {
            controller_instance = new Controller();
        }
        return controller_instance;
    }

    void gameLoop() {
        Commands commands = new Commands();
        welcome();
        basic_info();
        commandsInstructions();
        while (gameRunning) {
            ConsoleUtilities.pauseForInput();
            commands.interact();
        }
    }

    private void basic_info() {
        String basicInfo = jsonReader.getGameInfo()[1].getInfo();
        System.out.println(basicInfo);
    }

    private void welcome() {
        Path filepath = Paths.get("./src/main/java/resources/title.txt");

        try {
            String welcomeBanner = Files.readString(filepath);
            System.out.println("Welcome To: \n");
            System.out.println(welcomeBanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void commandsInstructions() {
        String basicInfo = jsonReader.getGameInfo()[0].getInfo();
        System.out.println(basicInfo);
    }

    public void quitGame() {
        System.out.println("Thanks for playing!");
        gameRunning = false;
    }

    public void newGame() {
        gameLoop();
    }
}