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
}
