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

    public String getNorth() {
        return north;
    }

    public String getSouth() {
        return south;
    }

    public String getEast() {
        return east;
    }

    public String getWest() {
        return west;
    }

    public String getDesc() {
        return desc;
    }

    public String getValidDirections(){

        if (getNorth().length() > 0){
            north = "north: " + getNorth() + " ";
        }
        if(getSouth().length() > 0){
            south = "south: " + getSouth()+ " ";
        }
        if (getWest().length() > 0){
            west = "west: " + getWest()+ " ";
        }
        if (getEast().length() > 0){
            east = "east: "+ getEast()+ " ";
        }

        return "Directions: " + north +  south  + east + west;

    }




    public String roomInfo(){
        return "Current Location: " + getName() + "\n" + "Description: " + getDesc()+ "\n" + "items: " + getItems() + "\n" + getValidDirections() ;

    }
}
