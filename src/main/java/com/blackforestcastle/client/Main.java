package com.blackforestcastle.client;


import com.blackforestcastle.Controller;
import com.blackforestcastle.*;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        controller.newGame();
    }
}