package com.sherbansoftware;

public class Main {

    /**
     * This is the entry point for a Java program.
     * In a Java program, the JVM goes directly and searches for a main method in order to execute it.
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        //Inside main method we define an original TV object based on a class (template for creating Java objects).
        Tv samsung = new Tv(new Screen("80 cm"));
        samsung.turnOn();
        Device device = new Device("2014 Mhz", "Off");
        samsung = new Tv("Samsung", new Resolution(1920, 1080), new Screen("80 cm"));
        samsung.turnOff();
        samsung = new Tv("Samsung", new Resolution(1920, 1080), new Screen("80 cm"), device.getInternalProcessor(), device.getPowerStatus());
        samsung.turnOn();
        // Tv class implements Cloneable interface to avoid CloneNotSupportedException being thrown
        // define a cloned object
        Tv samsungCloned = (Tv) samsung.getClone();
        samsungCloned.turnOff();

        Screen newSize = new Screen("90 cm");
        samsungCloned.setScreen(newSize);
        System.out.println("Samsung cloned object has a screen with a new size of: " + samsungCloned.getScreen().getSize() + " ");
        samsungCloned.turnOff();
    }
}
