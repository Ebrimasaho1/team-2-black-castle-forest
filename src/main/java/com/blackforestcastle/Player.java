package com.blackforestcastle;

import java.util.ArrayList;
import java.util.List;

class Player extends Character {

    Room currentRoom;

    Item sword;
    Item knife;
    Item bow;
    Item arrow;

    @Override
    public void attack(Character npc) {
        getPlayerAttackPower();
        int damageDone = getAttackPower() + randomNumber();
        npc.setHP(npc.getHP() - damageDone);
        System.out.println("You did " + damageDone + " damage. The enemies health now is " + npc.getHP());
    }

    // helper for attack method
    public void getPlayerAttackPower() {
        // knife, sword, bow, arrow
        for (Item item : inventory) {
            if (item.getName().equals("bow")) {
                for(Item item0 : inventory) {
                    if(item0.getName().equals("arrows")) {
                        setAttackPower(15);
                    }
                }

            }
            else if (item.getName().equals("sword")) {
                setAttackPower(10);
                }

            else if (item.getName().equals("knife")) {
                    setAttackPower(5);
                }

        }
    }

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
