package com.sherbansoftware;

/**
 * Created by Mihai Serban on 6/22/2017.
 */
public class Car {
    private String manufacturer;
    private String model;

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    //define a static method in order to create a new Car object
    //static methods does not use an instance variable to access it
    //static methods are loaded when the Car class is loaded by the JVM
    public static Car createCar(String manufacturer, String model){
        return new Car(manufacturer, model);
    }
}
