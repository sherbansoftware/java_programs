package com.sherbansoftware;

/**
 * Created by Mihai Serban on 6/20/2017.
 */
public class Room {
    private String name;
    private Tv tv;

    public Room(String name, Tv tv) {
        System.out.println("Room constructor with params called");
        this.name = name;
        this.tv = tv;
    }

    public String getName() {
        return name;
    }

    public Tv getTv() {
        return tv;
    }
}
