package com.sherbansoftware;

/**
 * Created by Mihai Serban on 6/17/2017.
 */
public class Resolution {
    //actual state
    private int height;
    private int weight;

    public Resolution(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
