package com.sherbansoftware;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mihai Serban on 6/22/2017.
 * ArrayList is better for retrieve objects.
 * For object manipulation use LinkList instead
 */
public class CarList {
    //actual state a carArrayList object contains a list of car objects
    private ArrayList<Car> carArrayList = new ArrayList<>(); //early instance create a new generic carArrayList
    private LinkedList<Car> carLinkedList = new LinkedList<>();

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public LinkedList<Car> getCarLinkedList() {
        return carLinkedList;
    }

    //add a car object to list
    public void addItem(Car car) {
        this.carLinkedList.add(car);
        System.out.println("The car object count is: " + carLinkedList.size());
    }

    //modify item
    public void modifyItem(int index, Car newCar) {
        carLinkedList.set(index, newCar);
        int position = index + 1;
        System.out.println("Car index " + position + " has been modified with: " + getItem(index).getModel());
    }

    //remove a car object from list
    public void removeItem(int position, Car car) {
        Car carToRemove = carLinkedList.get(position);
        carLinkedList.remove(carToRemove);
    }

    public void populateArrayList() {
        this.carArrayList.add(new Car("Dacia", "1310"));
        this.carArrayList.add(new Car("Dacia", "Dokker VAN"));
        this.carArrayList.add(new Car("Dacia", "New Sandero"));
    }

    private Car getItem(int index) {
        return carLinkedList.get(index);
    }

    public void listItems(List list) {
        System.out.println("The list object contains " + list.size() + " car objects");
        //Traversing list through for
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Model: " + getCarLinkedList().get(i).getModel() + ". Manufacturer: " + getCarLinkedList().get(i).getManufacturer());
        }
    }

    public void findItem(Car searchedCar) {
        boolean exists = carLinkedList.contains(searchedCar);

        if (exists) {
            int position = carLinkedList.indexOf(searchedCar) + 1;
            System.out.println("Found car object at position: " + position);
        } else {
            System.out.println("Car object not found");
        }

    }
}

