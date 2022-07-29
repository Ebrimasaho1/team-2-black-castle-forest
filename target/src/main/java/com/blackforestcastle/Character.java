package com.blackforestcastle;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private int attackPower;
    private int defendPower;
    private int HP;
    JSONReader jsonReader = new JSONReader();
    List<Item> inventory = new ArrayList<>();


    public int randomNumber() {
        int result = (int) ((Math.random() * 10) + 1);
        return result;
    }

    public abstract void attack(Character character);

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefendPower() {
        return defendPower;
    }

    public void setDefendPower(int defendPower) {
        this.defendPower = defendPower;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
