package com.blackforestcastle;

import java.util.Scanner;

public class Commands {
    Controller controller = Controller.getInstance();
    NPC npc = new NPC();
    Player player = new Player();
    JSONReader jsonReader = new JSONReader();
    Room[] rooms = jsonReader.getRooms();

    public void start() {
        player.setCurrentRoom(rooms[0]);
        player.setHP(100);
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
            case "bag":
                bag();
                break;
            case "get":
                get(noun);
                break;
            case "drop":
                drop(noun);
            case "attack":
                attack();
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
        } else {
            System.out.println("Invalid direction, enter a valid direction.");
        }
        System.out.println(player.getCurrentRoom().roomInfo());
    }

    void get(String item) {
        Item itemObject = player.currentRoom.checkRoomForItem(item);
        if (itemObject != null) {
            if (itemObject.getName().equals(item)) {
                player.inventory.add(itemObject);
                System.out.println("Items picked up: " + itemObject.getName());
                player.currentRoom.itemObjects.remove(itemObject);
            }
        }
    }

    void drop(String item) {

    }

    void bag() {
        player.showInventory();
    }

    void attack() {
        if (!player.currentRoom.getNpcObjects().isEmpty()) {
            battle();
        }
    }

    void battle() {
        Character npc = player.currentRoom.getNpcObjects().get(0);
        boolean battleOngoing = true;
        while (battleOngoing) {
            player.attack(npc);
            if (npc.getHP() <= 0) {
                System.out.println("You won the battle!!");
                player.currentRoom.getNpcObjects().remove(npc);
                break;
            }
            npc.attack(player);
            if (player.getHP() <= 0) {
                System.out.println("You're dead..");
                controller.newGame();

            }

        }
    }

    void look() {
        System.out.println(player.getCurrentRoom().roomInfo());
    }

    void teleport(String room) {
        System.out.println("You teleport to " + room);
    }

    void help() {
        System.out.println(controller.commandsInstructions());
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
