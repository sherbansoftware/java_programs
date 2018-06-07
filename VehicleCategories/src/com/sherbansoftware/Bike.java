package com.sherbansoftware;

import java.util.Optional;

/**
 * Created by Mihai Serban on 9/16/2017.
 */
public class Bike extends Vehicle {

    public Bike(Brand brand, String model, Optional<Engine> engine, Wheels wheels) {
        super(brand, model, engine, wheels);
    }

 public Integer listWheels(){
       return super.getWheels().getNumber().get().intValue();
 }
}
