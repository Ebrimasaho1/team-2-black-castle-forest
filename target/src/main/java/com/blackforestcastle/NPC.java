package com.blackforestcastle;

class NPC extends Character {

    String name;
    boolean isFriendly;

    @Override
    public void attack(Character player) {
        int damageDone = getAttackPower() + randomNumber();
        player.setHP(player.getHP()-damageDone);
        System.out.println("The enemy did " + damageDone + " damage. Your health is now " + player.getHP());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
