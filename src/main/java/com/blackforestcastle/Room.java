package com.blackforestcastle;

import java.util.ArrayList;
import java.util.List;

public class Room {

    String name;
    String[] items;
    List<Item> itemObjects = new ArrayList<>();
    List<NPC> npcObjects = new ArrayList<>();
    String north, south, east, west;
    String desc;
    String[] NPC;

    public Room(String name, String[] items, String north, String south, String east, String west, String desc, String[] NPC) {
        this.name = name;
        this.items = items;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.desc = desc;
        this.NPC = NPC;
    }

    public Room() {
    }

    public void makeNPCInstances() {
        JSONReader jsonReader = new JSONReader();
        NPC[] npcJSON = jsonReader.getNPC();
        for (String npc : NPC) {
            for (NPC npc0 : npcJSON) {
                if (npc.equals(npc0.getName())) {
                    npcObjects.add(npc0);
                }
            }
        }
    }


    public void makeItemInstances() {
        JSONReader jsonReader = new JSONReader();
        Item[] itemsJSON = jsonReader.getItems();
        for (String item : items) {
            for (Item itemO : itemsJSON) {
                if (item.equals(itemO.getName())) {
                    itemObjects.add(itemO);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public Item checkRoomForItem(String item) {
        for (Item itemObject : itemObjects) {
            if (item.equals(itemObject.getName())) {
                return itemObject;
            }
        }
        return null;
    }

    public String getNPCs() {
        String npcValue = "";
        for (NPC npc : npcObjects) {
            npcValue += npc.getName() + ", ";
        }
        return npcValue;
    }

    public String getItems() {
        String stuff = "";
        for (Item item : itemObjects) {
            stuff += item.getName() + ", ";
        }
        return stuff;
    }

    public String getDirection(String dir) {
        switch (dir) {
            case "north":
                return north;
            case "south":
                return south;
            case "east":
                return east;
            case "west":
                return west;
            default:
                return "Not a valid direction";
        }
    }

    public String getDesc() {
        return desc;
    }

    public String getValidDirections() {
        String direction1 = "";
        String direction2 = "";
        String direction3 = "";
        String direction4 = "";

        if (getDirection("north").length() > 0) {
            direction1 = "north: " + getDirection("north") + " ";
        }
        if (getDirection("south").length() > 0) {
            direction2 = "south: " + getDirection("south") + " ";
        }
        if (getDirection("west").length() > 0) {
            direction3 = "west: " + getDirection("west") + " ";
        }
        if (getDirection("east").length() > 0) {
            direction4 = "east: " + getDirection("east") + " ";
        }

        return "Directions: " + direction1 + direction2 + direction3 + direction4;

    }

    public List<com.blackforestcastle.NPC> getNpcObjects() {
        return npcObjects;
    }

    public String roomInfo() {
        return "Current Location: " + getName() + "\n" + "Description: " + getDesc() + "\n" + "Items: " + getItems() + "\n" + getValidDirections()
                + "\n" + "NPCs: " + getNPCs();

    }
}
