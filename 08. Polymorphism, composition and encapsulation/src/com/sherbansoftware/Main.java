package com.sherbansoftware;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("AGH model", "Volkswagen", 1888);
        Door door = new Door(4);
        Car car = new Car("Golf 4", engine, door, 4);
        car.startVehicle();
        car.stopVehicle();

        try {
            boolean value = Vehicle.checkType(car, "com.sherbansoftware.Car");
            System.out.println("value is: " + value);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
    }
}
