package com.sherbansoftware;

public class Car extends Vehicle {

    private int doors;
    private int wheels;
    private String colour;

    //default constructor
    public Car() {
        System.out.println("Default constructor");
    }

    //explicit constructors
    public Car(String name, String model, Engine engine, String colour) {
        this(4, 4, name, model, engine, colour);
        System.out.println(" calling another constructor using this()");
    }

    public Car(int doors, int wheels) {
        super("Vehicle name", "Vehicle model", new Engine("Vehicle engine"));
        this.doors = doors;
        this.wheels = wheels;
    }

    public Car(int doors, int wheels, String name, String model, Engine engine, String colour) {
        super(name, model, engine);
        this.doors = doors;
        this.wheels = wheels;
        this.colour = colour;
        System.out.println("Explicit constructor");
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public Engine getEngine() {
        return super.getEngine();
    }

    public String getColour() {
        return colour;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setName(String name) {
        String validName = name.toLowerCase();
        if (validName.equals("dacia") || validName.equals("volkswagen"))
            this.name = name;
        else
            this.name = "Unknown";
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void start() {
        //super.start();
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        //super.stop();
        System.out.println("Car stopped");
    }

    @Override
    public String toString() {
        return String.format("%s, Name: %s, Model: %s, Doors: %d, Wheels: %d,Colour: %s, Engine model: %s", this.getClass().getCanonicalName(), this.getName(), this.getModel(), this.getDoors(), this.getWheels(), this.getColour(), getEngine().getModel());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
