package com.sherbansoftware;

public class Engine {
    private String model;
    private String manufacturer;
    private int engineCapacity;


    public Engine(String model, String manufacturer, int engineCapacity) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.engineCapacity = engineCapacity;
    }

    private String getModel() {
        return model;
    }

    private String getManufacturer() {
        return manufacturer;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void startEngine() {
        System.out.println( getModel() + " made by " + getManufacturer() + " with " + getEngineCapacity() + " rpm engine started");
    }

    public void stopEngine() {
        System.out.println( getModel() + " made by " + getManufacturer() + " with " + getEngineCapacity() + " rpm engine stopped");
    }
}
