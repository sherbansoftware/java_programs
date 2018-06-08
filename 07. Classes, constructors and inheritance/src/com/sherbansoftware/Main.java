package com.sherbansoftware;

public class Main {

    public static void main(String[] args) {
        System.out.println("Constructing objects");

        //create a new data type "dacia" of type Car using the default constructor
        Car dacia = new Car();
        dacia.setName("Dacia");
        dacia.setColour("Blue");
        dacia.setDoors(4);
        dacia.setWheels(4);
        dacia.setModel("1310");
        dacia.setEngine(new Engine("AXR"));
        dacia.start();
        dacia.stop();
        System.out.println(dacia);

        //create a new data type "volkswagen" of type Car using the explicit constructor
        Car volkswagen = new Car(4, 4, "Volkswagen", "Golf", new Engine("ALH"), "Gray");
        volkswagen.start();
        volkswagen.stop();
        System.out.println(volkswagen);

        //create a new data type "porsche" of type Car using the explicit constructor using this in order to call another constructor
        Engine porscheEngine = new Engine("Porsche Engine");
        Car porsche = new Car("Porsche", "Carera", porscheEngine, "Pink");
        porsche.start();
        porsche.stop();
        System.out.println(porsche);

        Vehicle vehicle = new Vehicle("Vehicle name", "Vehicle model", new Engine("Vehicle Engine"));
        vehicle.start();
        vehicle.stop();
        System.out.println(vehicle);

        Car vehicleCar = new Car(8, 8);
        System.out.println(vehicleCar);

    }
}
