package com.blackforestcastle;

import java.util.ArrayList;
import java.util.List;

class Player extends Character {

    Room currentRoom;
    List<Item> inventory = new ArrayList<>();

    public void showInventory() {
        System.out.print("Inventory: ");
        for (Item item : inventory) {
            System.out.print(item.getName() + ", ");
        }
        System.out.println();
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
