package com.sherbansoftware;

public abstract class Animal implements IAnimal{

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
