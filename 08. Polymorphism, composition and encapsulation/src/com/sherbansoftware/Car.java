package com.sherbansoftware;

public class Car extends Vehicle {
    private int wheels;

    public Car(String name, Engine engine, Door door, int wheels) {
        super(name, engine, door);
        this.wheels = wheels;
    }

    private int getWheels() {
        return wheels;
    }

    @Override
    public void startVehicle() {
        super.startVehicle();
        System.out.println("The " + getClass().getName() + " has " + this.getWheels() + " wheels");

    }

    @Override
    public void stopVehicle() {
        super.stopVehicle();
    }
}
