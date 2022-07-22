package com.blackforestcastle;

import java.util.Objects;
import java.util.Scanner;

public class Commands {
    Controller controller = Controller.getInstance();
    Player player = new Player();
    JSONReader jsonReader = new JSONReader();
    Room[] rooms = jsonReader.getRooms();

    public void start() {
        player.setCurrentRoom(rooms[0]);
    }

    //Parse input text and return as an array split into verb and noun
    String[] input() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.print(">>");
        String input = scanner.nextLine();

        String[] splitInput = input.split(" ");// Read user input and split into an array based off of regex.
        return splitInput;
    }

    public void interact() {
        System.out.println("What would you like to do?");
        String[] input = input();
        String verb = "";
        String noun = "";
        if (input.length == 1) {
            verb = input[0].toLowerCase();
        } else if (input.length == 2) {
            verb = input[0].toLowerCase();
            noun = input[1].toLowerCase();
        } else {
            System.out.println("Please enter a valid command, such as: ");
            controller.commandsInstructions();
            return;
        }

        switch (verb) {
            case "go":
                go(noun);
                break;
            case "get":
                get(noun);
                break;
            case "fight":
                fight(noun);
                break;
            case "look":
                look();
                break;
            case "teleport":
                teleport(noun);
                break;
            case "?":
                help();
                break;
            case "quit":
                controller.quitGame();
                break;
            case "new":
                controller.newGame();
                break;
            default:
                controller.commandsInstructions();
        }
    }

    void go(String direction) {
        if (direction.matches("north|east|south|west")) {
            goToRoom(direction);
        }
        else {
            System.out.println("Invalid direction, enter a valid direction.");
        }
        System.out.println(player.getCurrentRoom().roomInfo());
    }

    void get(String item) {
        System.out.println("Getting " + item);
    }

    void fight(String npc) {
        System.out.println("Fighting " + npc);
    }

    void look() {
        System.out.println("You look around");
    }

    void teleport(String room) {
        System.out.println("You teleport to " + room);
    }

    void help() {
        System.out.println("This will display the commands");
    }

    //Helper functions
    void goToRoom(String direction) {
        for (Room room : rooms) {
            if (room.getName().equals(player.getCurrentRoom().getDirection(direction))) {
                player.setCurrentRoom(room);
                break;
            }
        }
    }
}
