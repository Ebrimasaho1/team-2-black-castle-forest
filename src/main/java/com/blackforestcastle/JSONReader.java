package com.blackforestcastle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {

    // this method parses the rooms.json folder and returns a Rooms Array object
    public Room[] getRooms() {
        Room[] rooms = {};
        try {
            Gson gson = new Gson();
            //String reader = Files.readString(Paths.get("./src/main/java/resources/rooms.json"));
            Reader reader1 = new FileReader("./src/main/java/resources/rooms.json");
            rooms = gson.fromJson(reader1, Room[].class);
            for (Room room : rooms) {
                room.makeItemInstances();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        }
        return rooms;
    }

    // This method parses the gameInfo.json file and returns a GameInfo Object that contains the required information.
    public GameInfo[] getGameInfo() {
        GameInfo[] info1 = {};
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader("./src/main/java/resources/gameInfo.json");
            info1 = gson.fromJson(reader, GameInfo[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        }
        return info1;
    }

    public Item[] getItems() {
        Item[] info1 = {};
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader("./src/main/java/resources/items.json");
            info1 = gson.fromJson(reader, Item[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        }
        return info1;
    }
}