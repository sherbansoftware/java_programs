package com.sherbansoftware;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mihai Serban on 6/22/2017.
 * ArrayList is better for retrieve objects.
 * For object manipulation use LinkList instead
 */
public class CarList {
    //actual state a carLinkedList object contains a list of car objects
    //early instance to create a new generic carList that is instantiated with the LinkedList empty constructor
    private List<Car> carLinkedList = new LinkedList<>();
    //If you do not use a early instance you can instantiate the carLinkedList object in the CarList constructor:
    /*
    //used early instance in this case. Just for example
    public CarList(){
        this.carLinkedList = new new LinkedList<>();
    }
    */

    public List<Car> getCarLinkedList() {
        return carLinkedList;
    }

    //add a car object to list and return true if the item has added or false otherwise
    public boolean addNewItem(Car car) {
        if (findItem(car, carLinkedList) >= 0){
            System.out.println("The car: " + car.getManufacturer() + " " + car.getModel() + " is already in list");
            return false;
        }

        this.carLinkedList.add(car);
        System.out.println("The car object count is: " + carLinkedList.size());
        System.out.println("\t Added: " + car.getManufacturer() + " " + car.getModel());
        return true;
    }

    //modifyItem method based on a new Car object.
    //Call the modifyItem method based on an index and new Car object.
    public void modifyItem(Car newCar) {
        int position = findItem(newCar, carLinkedList);
        if (position >= 0) {
            modifyItem(position, newCar);
        }
    }

    //modifyItem method based on an index and new Car object.
    public void modifyItem(int index, Car newCar) {
        carLinkedList.set(index, newCar);
        int position = index + 1;
        System.out.println("Car index " + position + " has been modified with new Model: " + getItem(index).getModel() + " and Manufacturer: " + getItem(index).getManufacturer());
    }

    //removeItem method removes the car object parsed as parameter from list.
    // Call the removeItem method that removes a car object from list based on it's index
    public void removeItem(Car carToBeRemoved) {
        int position = findItem(carToBeRemoved, carLinkedList);
        if (position >= 0) {
            removeItem(position);
        }
    }

    //removeItem method removes a car object from list based on it's index
    public void removeItem(int position) {
        Car carToRemove = carLinkedList.get(position);
        carLinkedList.remove(carToRemove);
    }

    public void populateListWithObjects() {
        this.carLinkedList.add(new Car("Dacia", "1310"));
        this.carLinkedList.add(new Car("Dacia", "Dokker VAN"));
        this.carLinkedList.add(new Car("Dacia", "New Sandero"));
    }

    private Car getItem(int index) {
        return carLinkedList.get(index);
    }

    public void listItems(List list) {
        System.out.println("The list object contains " + list.size() + " car objects");
        //Traversing list through for
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t Car: " + (i + 1) + " - Manufacturer: " + getCarLinkedList().get(i).getManufacturer() + ". Model: " + getCarLinkedList().get(i).getModel());
        }
    }

    //public method to find item and return a Car object. Accessed from outside class
    public Car findItem(Car searchedCar) {
        boolean exists = carLinkedList.contains(searchedCar);
        int position = 0;
        if (exists) {
            position = carLinkedList.indexOf(searchedCar) + 1;
            System.out.println("\t Found car object at position: " + position);
        } else {
            System.out.println("\t Car object not found");
        }
        return carLinkedList.get(position);
    }

    //public method to find item and return it's index. Accessed from outside class
    public int findItem(Car searchedCar, List list) {
        return list.indexOf(searchedCar);
    }

}

