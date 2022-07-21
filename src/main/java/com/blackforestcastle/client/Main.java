package com.blackforestcastle.client;

import com.blackforestcastle.Controller;

class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        controller.newGame();
    }
}
