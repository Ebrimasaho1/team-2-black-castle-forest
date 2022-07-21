package com.blackforestcastle.client;

import com.blackforestcastle.*;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        /*Controller controller = Controller.getInstance();
        controller.newGame();

         */
        JSONReader j = new JSONReader();
        //j.getRooms();
        Room[] m = j.getR();
        for (Room rm : m){
            System.out.println(rm.roomInfo());
        }

        GameInfo[] gInfo = j.getGameInfo();
        System.out.println(gInfo[0].getInfo());






    }
}
