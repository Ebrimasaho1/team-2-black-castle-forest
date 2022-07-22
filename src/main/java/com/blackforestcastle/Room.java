package com.blackforestcastle;

public class Room {

    String name;
    String[] items;
    String north, south, east, west;
    String desc;

    public Room(String name, String[] items, String north, String south, String east, String west, String desc) {
        this.name = name;
        this.items = items;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.desc = desc;
    }
    public Room(){

    }

    public String getName() {
        return name;
    }

    public String getItems() {
        String stuff = "";
        for (String item: items) {
            stuff +=  item + ", ";



        }
        return stuff;
    }

    public String getDirection(String dir) {
        switch (dir){
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

    public String getValidDirections(){
        String direction1 = "";
        String direction2= "";
        String direction3="";
        String direction4 ="";

        if (getDirection("north").length() > 0){
            direction1 = "north: " + getDirection("north")+ " ";
        }
        if(getDirection("south").length() > 0){
            direction2 = "south: " + getDirection("south")+ " ";
        }
        if (getDirection("west").length() > 0){
            direction3 = "west: " + getDirection("west")+ " ";
        }
        if (getDirection("east").length() > 0){
            direction4 = "east: "+ getDirection("east")+ " ";
        }

        return "Directions: " + direction1 +  direction2  + direction3 + direction4;

    }




    public String roomInfo(){
        return "Current Location: " + getName() + "\n" + "Description: " + getDesc()+ "\n" + "items: " + getItems() + "\n" + getValidDirections() ;

    }
}
