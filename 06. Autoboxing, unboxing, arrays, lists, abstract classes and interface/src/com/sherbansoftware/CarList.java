package com.sherbansoftware;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mihai Serban on 6/22/2017.
 * ArrayList is better for retrieve objects.
 * For object manipulation use LinkList instead
 */
public class CarList {
    //actual state a carLinkedList object contains a list of car objects
    //early instance to create a new generic carList that is instantiated with the empty List constructor
    private List<Car> carLinkedList = new LinkedList<>();
    //If you do not use a early instance you can instantiate the empty List object in the CarList constructor:
    /*
    // used early instance in this case. Just for example
    // instantiate the empty List object in the CarList constructor:
    public CarList(){
        this.carLinkedList = new LinkedList<>(); //empty list. (no values)
    }
    */

    //getter for List
    public List<Car> getCarLinkedList() {
        return carLinkedList;
    }

    //getter for Car item
    private Car getItem(int index) {
        return carLinkedList.get(index);
    }

    //populate List With Hardcoded Objects
    public void populateListWithHardcodedObjects() {
        this.carLinkedList.add(new Car("Dacia", "1310"));
        this.carLinkedList.add(new Car("Dacia", "Dokker VAN"));
        this.carLinkedList.add(new Car("Dacia", "New Sandero"));
        System.out.println("Added hardcoded values to car list");
    }

    //list Items
    public void listItems(Collection<Car> collectionOfCars) {
        System.out.println("The list object contains " + collectionOfCars.size() + " car objects");

        //Traversing list through for
        for (int i = 0; i < collectionOfCars.size(); i++) {
            System.out.println("\t Car: " + (i + 1) + " - Manufacturer: " + getCarLinkedList().get(i).getManufacturer() + ". Model: " + getCarLinkedList().get(i).getModel());
        }

        //Traversing list through Iterator
        Iterator<Car> iterator = collectionOfCars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println("Car: " + car);
        }

        //Traversing list through for each
        for (Car car : collectionOfCars) {
            System.out.println("Car: " + car);
        }

        //Traversing list through for each with index
        int i = 0;
        for (Car car : collectionOfCars) {
            System.out.println("\t Car: " + (i + 1) + " - Manufacturer: " + car.getManufacturer() + ". Model: " + car.getModel());
            i++;
        }
    }

    //add a car object to list and return true if the item has added or false otherwise
    public boolean addNewItem(Car newCar) {
        if (findItem(newCar.getManufacturer(), this.carLinkedList) >= 0) {
            System.out.println("The car: " + newCar.getManufacturer() + " " + newCar.getModel() + " is already on list");
            return false;
        }

        this.carLinkedList.add(newCar);
        System.out.println("The new car object count is: " + carLinkedList.size());
        System.out.println("\t Added: " + newCar.getManufacturer() + " " + newCar.getModel());
        return true; //successfully added the item
    }

    // add new Car with all the car attributes
    public boolean addNewItem(String manufacturer, String model) {
        if (findItem(manufacturer, model) == null) {
            this.carLinkedList.add(new Car(manufacturer, model));
            return true;
        }
        return false;
    }

    //Overload updateItem
    //updateItem method based on an old and a new Car object.
    public boolean updateItem(Car oldCar, Car newCar) {
        int foundPosition = findItem(oldCar, carLinkedList);
        if (foundPosition < 0) {
            System.out.println(oldCar.getManufacturer() + " " + oldCar.getModel() + " was not found");
            return false;
        }
        this.carLinkedList.set(foundPosition, newCar);
        System.out.println(oldCar.getManufacturer() + " " + oldCar.getModel() + " was replaced with " + newCar.getManufacturer() + " " + newCar.getModel());
        return true;
    }

    //updateItem method based on a new Car object.
    //Call the updateItem method based on an index and new Car object.
    public void updateItem(Car newCar) {
        int position = findItem(newCar, carLinkedList);
        if (position >= 0) {
            updateItem(position, newCar);
        }
    }

    //updateItem method based on an index and new Car object.
    public void updateItem(int index, Car newCar) {
        carLinkedList.set(index, newCar);
        int position = index + 1;
        System.out.println("Car index " + position + " has been modified with new Model: " + getItem(index).getModel() + " and Manufacturer: " + getItem(index).getManufacturer());
    }

    //removeItem method removes a car object from a List based on start and end position
    public void removeItem(List<Car> list, int startPosition, int endPosition) {
        list.subList(startPosition, endPosition).clear(); //remove items
    }

    //removeItem method removes the car object parsed as parameter from list.
    // Call the removeItem method that removes a car object from list based on it's index
    public void removeItem(Car carToBeRemoved) {
        int position = findItem(carToBeRemoved, carLinkedList);
        if (position >= 0) {
            removeItem(position);
        }
    }

    // add new Car with all the car attributes
    public boolean removeItem(String manufacturer, String model) {
        if (findItem(manufacturer, model) != null) {
            this.carLinkedList.remove(new Car(manufacturer, model));
            return true;
        }
        return false;
    }

    //removeItem method removes a car object from list based on it's index
    private void removeItem(int position) {
        Car carToRemove = carLinkedList.get(position);
        carLinkedList.remove(carToRemove);
    }

    //Overloaded methods: findItem
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

    /* private method, accessed within the class, to find an item and return an integer:
     Params: The object attribute, and the list we're looking the item
     - -1 if does not exist on the list
     - 0 or 1 - if exist
      */
    private int findItem(String carManufacturerToBeSearched, List<Car> list) {
        carManufacturerToBeSearched = carManufacturerToBeSearched.trim();

        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i); //create a new object
            if (car.getManufacturer().equalsIgnoreCase(carManufacturerToBeSearched)) {
                return i; //return the position in the List when the item is found
            }
        }
        return -1; //when the item is not found
    }

    /* private method, accessed within the class, to find an item and return an integer:
 Params: The object attribute, and the list we're looking the item
 - -1 if does not exist on the list
 - 0 or 1 - if exist
  */
    private Car findCarItem(String carManufacturerToBeSearched, List<Car> list) throws CarNotFoundException {
        carManufacturerToBeSearched = carManufacturerToBeSearched.trim();

        for (Car car : list) {
            if (car.getManufacturer().equalsIgnoreCase(carManufacturerToBeSearched)) {
                return car;
            }
        }
        throw new CarNotFoundException("Car not found!!");
    }

    /* private method, accessed within the class, to find an item and return a Car:
     Params: The object attribute, and the list we're looking the item
     - alternative to previous method
      */
    private Car findItem(String manufacturer, String model) {
        for (Car checkedCar : carLinkedList) {
            if (checkedCar.getManufacturer().equals(manufacturer) && checkedCar.getModel().equals(model)) {
                return checkedCar;
            }
        }
        return null;
    }

    /* private method, accessed within the class, to find an item and return a Car object:
  */
    private Car findItemReturnCar(String carManufacturerToBeSearched) {
        for (Car searchedItem : this.carLinkedList) {
            if (searchedItem.getManufacturer().equalsIgnoreCase(carManufacturerToBeSearched)) {
                return searchedItem; //return the searchedItem
            }
        }
        return null; //when the item is not found
    }

    private Car findItemReturnCarInCollection(Car carToFind, Collection<Car> carCollection) {
        Iterator<Car> iterator = carCollection.iterator();    //better with ArrayList not LinkedList

        while (iterator.hasNext()) {
            if (carCollection.contains(carToFind)) {
                return carToFind;
            }
        }
        return null; //when the item is not found
    }

    private void findItemReturnCarInCollection(Car carToFind, List<Car> carLinkedListli) {
        ListIterator<Car> iterator = carLinkedList.listIterator();    //better with ArrayList not LinkedList

        while (iterator.hasNext()) {
            Car nextCar = iterator.next();
            iterator.set(carToFind);
        }
    }

    /* private method, accessed within the class, to find an item and return an integer:
    Params: The car object, and the list we're looking the item
    - -1 if does not exist on the list
    - 0 or 1 - if exist
     */
    private int findItem(Car searchedCar, List list) {
        return list.indexOf(searchedCar);
    }


    public void searchForItem(String carManufacturer, String carModel) {
        List<Car> result = getCarLinkedList().stream()
                .filter(item -> (item.getManufacturer().equals(carManufacturer) && item.getModel().equals(carModel)))
                .collect(Collectors.toList());

        System.out.println("Result size: " + result.size());
    }
}

