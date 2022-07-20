package com.blackforestcastle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

class Controller {


    private static void basic_info() {
        System.out.println();
        System.out.println("You are an avid hiker, exploring a new trail on a weekend. You lose your footing and stumble down the hill."
                + "\nWhen you get up and regain your bearing, you look up and see a castle with beautiful artistic design and lightning."
                + "\nYou walk into the castle with the hope of exploring its beauty and all of a sudden, you are trapped and cannot escape"
                + "\nYou shout for help but no one can hear you and now it is up to you to escape the castle alive by whatever means necessary");

    }

    ;


    private static void welcome() throws IOException, InterruptedException {
        String welcomeBanner = Files.readString(Path.of("Resources", "Title"));
        System.out.println("Welcome To: \n");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println(welcomeBanner);


    }

}
