package com.sherbansoftware;

public class Main {

    /**
     * This is the entry point for a Java program.
     * In a Java program, the JVM goes directly and searches for a main method in order to execute it.
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        //simulate Mihai Serban's bedroom
        Room bedroom = new Room("Mihai Serban", new Tv());
        String tv = bedroom.getName();
        System.out.println("TV is: " + tv);

        //Inside main method we define an original TV object based on a class (template for creating Java objects).
        Tv samsung = new Tv(new Screen("LCD"));
        samsung.turnOn();
        Device device = new Device("2014 Mhz", "Off ");
        samsung = new Tv("Samsung", new Resolution(1920, 1080), new Screen("Ultra HD"));
        samsung.turnOff();
        Resolution resolution = new Resolution(1920, 1080);
        Screen screen = new Screen("HD ready");
        samsung = new Tv("Samsung", resolution, screen, device.getInternalProcessor(), device.getPowerStatus());
        samsung.turnOn();

        String type = samsung.getScreen().getType(); //access a particular screen attribute using the Tv object.
        samsung.getScreen().setType("Q" + type); //Method chaining

        /*
        instanceof operator is used to test whether the object is an instance
        of the specified class or subclass or interface
        */
        //polymorphism example
        if (type instanceof String) {
            type = device.showPolymorphism();
            System.out.println(type);
            type = samsung.showPolymorphism();
            System.out.println(type);
        }

        // Tv class implements Cloneable interface to avoid CloneNotSupportedException being thrown
        // define a cloned object
        Tv samsungCloned = (Tv) samsung.getClone();
        samsungCloned.turnOff();

        Screen fullHd = new Screen("Full HD");
        samsungCloned.setScreen(fullHd);
        System.out.println("Samsung cloned object has a screen with a new type of screen: " + samsungCloned.getScreen().getType() + " ");
        samsungCloned.turnOff();

        Engine engine = new Engine("AGH model", "Volkswagen", 1888);
        Door door = new Door(4);
        Car car = new Car("Golf 4", engine, door, 4);
        car.startVehicle();
        car.stopVehicle();

        //handle checkType
        try {
            boolean value = Vehicle.checkType(car, "com.sherbansoftware.Car");
            System.out.println("value is: " + value);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
    }

}
