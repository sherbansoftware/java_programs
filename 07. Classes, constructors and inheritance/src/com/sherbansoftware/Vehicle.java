package com.sherbansoftware;

public class Vehicle {
    protected String name;
    protected String model;
    protected Engine engine;

    //default constructor
    public Vehicle() {
        System.out.println("Vehicle Default constructor");
    }

    public Vehicle(String name, String model, Engine engine) {
        this.name = name;
        this.model = model;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        System.out.println("Vehicle started");
    }

    public void stop(){
        System.out.println("Vehicle stopped");
    }

    @Override
    public String toString() {
        return String.format("%s, Name: %s, Model: %s, Engine model: %s", this.getClass().getCanonicalName(), this.getName(), this.getModel(), getEngine().getModel());
    }
}
