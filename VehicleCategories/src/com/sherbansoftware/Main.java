package com.sherbansoftware;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Engine engine = new Engine(null);
        Optional<Engine> engineOptional = Optional.ofNullable(engine);
        Vehicle vehicle = new Vehicle(new Brand(), new String("1310"), engineOptional, new Wheels());
        System.out.println(vehicle.getWheels().getNumber().get());
        vehicle.decelerate();

        if(vehicle.getBrand(vehicle).getBrand() == null){
            vehicle.setBrand(vehicle, "Dacia");
        }
        System.out.println(vehicle.getBrand(vehicle).getBrand());
        System.out.println(vehicle.getBrand(vehicle).getBrand());

        Bike bike = new Bike(new Brand(), new String("Pegas"), engineOptional, new Wheels());
        if(engineOptional.isPresent()) {
            bike.getWheels().setNumber(Optional.ofNullable(2));
        } else {
            System.out.println("no engine");
        }
        System.out.println(bike.listWheels());
        System.out.println(bike.getModel());


        IVechicle iVechicle = new Vehicle(new Brand(), new String("1310"), new Wheels());
        iVechicle.accelerate();

        Vehicle vehicle1 = new Vehicle(new Brand(), new String("1310"), new Wheels());
        vehicle1.start();

    }
}
