package com.blackforestcastle;

public class Controller {
    boolean gameRunning = true;

    void gameLoop() {
        Commands commands = new Commands();

        basic_info();
        while (gameRunning) {
            commands.interact();
        }
    }



    private void basic_info() {
        System.out.println();
        System.out.println("You are an avid hiker, exploring a new trail on a weekend. You lose your footing and stumble down the hill."
        + "\nWhen you get up and regain your bearing, you look up and see a castle with beautiful artistic design and lightning."
        + "\nYou walk into the castle with the hope of exploring its beauty and all of a sudden, you are trapped and cannot escape"
        + "\nYou shout for help but no one can hear you and now it is up to you to escape the castle alive by whatever means necessary");

    }

    public void commandsInstructions() {
        System.out.println();
        System.out.println("Game commands");
        System.out.println("---------------------------------------------");
        System.out.println("** 'Move' --> directions [e.g move south] **" +
                "\n** 'go'   --> directions [e.g go north] **" +
                "\n** 'look' --> current location **" +
                "\n** 'get'  --> get item [e.g get key] **" +
                "\n** 'use'  --> use item [e.g use key] **" +
                "\n** 'fight'--> initiate combat **" +
                "\n** 'teleport' --> Take you to a random location **" +
                "\n** '?' --> help **");
        System.out.println("-----------------------------------------------");
    }

    public void quitGame() {
        System.out.println("Thanks for playing!");
        gameRunning = false;
    }

    public void newGame() {
        gameLoop();
    }
}
