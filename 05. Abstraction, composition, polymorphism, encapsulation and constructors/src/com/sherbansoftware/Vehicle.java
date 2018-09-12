package com.sherbansoftware;

/*
- can contain non abstract methods
- can contain member variables also
- must use the abstract keyword to make a method abstract
 */
public abstract class Vehicle implements IVehicle {
    private String name;
    private Engine engine;  //composition has-a relationship
    private Door door;

    public Vehicle(String name, Engine engine, Door door) {
        this.name = name;
        this.engine = engine;
        this.door = door;
    }

    private String getName() {
        return name;
    }

    private Door getDoor() {
        return door ;
    }

    private Engine getEngine() {
        return engine;
    }

    public void startVehicle(){
        getEngine().startEngine();
        System.out.println("Vehicle started");
        System.out.println(this.getName() + " has " + this.getDoor().getDoorNumber() + " doors ");
    }

    public void stopVehicle(){
        getEngine().stopEngine();
        System.out.println("Vehicle stopped");
    }

    //static method that checks the variable type
    public static boolean checkType(Object obj, String c) throws ClassNotFoundException {
        return Class.forName(c).isInstance(obj);
    }
}
