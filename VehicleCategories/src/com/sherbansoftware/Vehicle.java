package com.sherbansoftware;


import java.util.Optional;

/**
 * Created by Mihai Serban on 9/16/2017.
 */
public class Vehicle extends AbstractVehicle implements IVechicle{
    //state
    private Brand brand;
    private String model;
    private Optional<Engine> engine;
    private Wheels wheels;

    public Vehicle(Brand brand, String model, Optional<Engine> engine, Wheels wheels) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.wheels = wheels;
    }

    public Vehicle(Brand brand, String model, Wheels wheels) {
        this.brand = brand;
        this.model = model;
        this.wheels = wheels;
    }

    private Brand getBrand() {
        return brand;
    }
    private Brand setBrand(Brand brand) {
        return this.brand = brand;
    }

    public void setBrand(Vehicle vehicle, String brand){
        vehicle.getBrand(vehicle).setBrand(brand);
    }

    public Brand getBrand(Vehicle vehicle) {
        return vehicle.getBrand();
    }

    protected String getModel() {
        return model;
    }

    private Optional<Engine> getEngine() {
        return engine;
    }

    protected Wheels getWheels() {
        return wheels;
    }

    @Override
    public void accelerate() {
        this.engine.get().increaseRpms(100);
    }

    @Override
    public void decelerate() {
        this.engine.get().decreaseRpms(100);
    }
}
