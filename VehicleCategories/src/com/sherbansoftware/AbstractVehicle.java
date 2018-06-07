package com.sherbansoftware;

/**
 * Created by Mihai Serban on 11/12/2017.
 */
public abstract class AbstractVehicle implements IVechicle {


    public abstract void accelerate();
    public abstract void decelerate();

    void stop(){
        System.out.println("The vehicle stops");
    }

    void start(){
        System.out.println("The vehicle stops");
    }
}
