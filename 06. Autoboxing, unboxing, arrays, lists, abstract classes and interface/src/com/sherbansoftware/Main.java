package com.sherbansoftware;

import java.util.Scanner;

/**
 * Java array is an object the contains elements of similar data type. It is a data structure where we store similar elements. We can store only fixed set of elements in a java array.
 * Eg. array of characters, array of integer, array of String, array of SomeObject
 */
public class Main {
    private static CarList carList = new CarList();
    private static Scanner scanner = new Scanner(System.in);

    // static method which return the average of array elements
    private static double getAvgOfArrElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / (double) arr.length;
    }

    //private static methods from the switch statement
    private static void listItems() {
        carList.listItems(carList.getCarLinkedList());
    }

    private static void addItem() {
        System.out.print("Enter a car manufacturer: ");
        String carManufacturer = scanner.nextLine();
        System.out.print("Enter a car model: ");
        String carModel = scanner.nextLine();
        Car carToBeAdded = new Car(carManufacturer, carModel);
        carList.addNewItem(carToBeAdded);
    }

    private static void modifyItem() {
        System.out.print("Enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();

        Car carToBeModified = new Car("Manufacturer to be modified", "Model to be modified");
        //Note that for the user should not use an index to access particular elements in order to modify a car item. Just as example.
        carList.modifyItem(itemNo - 1, carToBeModified);  // //call to modify a car based on it's index
        System.out.println();
        carList.modifyItem(new Car("Dacia", "Berlina")); //call to modify a specific car
    }

    private static void removeItem() {
        System.out.print("Enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        //Note that for the user should not use an index to access particular elements in order to remove a car item. Just as example.
        carList.removeItem(itemNo - 1); //call to remove a car based on it's index
        carList.removeItem(new Car("Dacia", "Berlina"));  //call to remove a specific car

    }

    private static void searchForItem() {
        System.out.print("Enter a car manufacturer to be searched: ");
        String carManufacturer = scanner.nextLine();
        System.out.print("Enter a car model to be searched: ");
        String carModel = scanner.nextLine();
        Car searchedCar = new Car(carManufacturer, carModel);
        if (carList.findItem(searchedCar) != null) {
            System.out.println("Found " + searchedCar.getManufacturer() + " " + searchedCar.getModel() + " in  our car list" + " at position: " + carList.getCarLinkedList().indexOf(searchedCar));
        } else {
            System.out.println(searchedCar.getManufacturer() + " " + searchedCar.getModel() + " is not in the car list");
        }
    }

    private static void printinstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of car items.");
        System.out.println("\t 2 - To add a car item to the list.");
        System.out.println("\t 3 - To modify a car item in the list.");
        System.out.println("\t 4 - To remove a car item from the list.");
        System.out.println("\t 5 - To search for a car item in the car list.");
        System.out.println("\t 6 - To quit the application.");
    }

    //Entry point for JVM
    public static void main(String[] args) {
        int[] arrayOfInt = new int[5];//declaration and instantiation, space for 5 elements. [] may be after or before variable name.
        arrayOfInt[0] = 5; //initialization of first element
        arrayOfInt[1] = 20;
        arrayOfInt[2] = 80;
        arrayOfInt[3] = 32;
        arrayOfInt[4] = 43; //initialization of last element

        //reassign values to array elements
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfInt[i] += 10;
        }

        //list the new array elements with for each
        System.out.println("list the new array elements with for each loop");
        int count = 0;
        for (int i : arrayOfInt) {
            System.out.printf("arrayOfInt[" + count + "] = %10d\n", i); //add 10 spaces before element value
            count++;
        }
        System.out.println();
        System.out.println("list the new array elements with while loop");

        //list the new array elements with while loop
        count = 0;
        while (count < arrayOfInt.length) {
            System.out.printf("arrayOfInt[" + count + "] = %10d\n", arrayOfInt[count]); //add 10 spaces before element value
            count++;
        }

        //print the average to console
        double average = getAvgOfArrElements(arrayOfInt);
        System.out.println("The average is: " + average);

        //define a List of cars which has it s size allocated dynamically
        carList.addNewItem(new Car("Dacia", "1310"));
        carList.addNewItem(new Car("Dacia", "Sandero"));
        carList.addNewItem(new Car("Dacia", "Logan"));
        carList.addNewItem(new Car("Dacia", "Logan MCV"));
        Car findCar = new Car("Dacia", "Dokker");
        carList.addNewItem(findCar);
        carList.addNewItem(new Car("Dacia", "Lodgy"));


        carList.modifyItem(0, new Car("Dacia", "Berlina"));

        carList.findItem(findCar);

        carList.listItems(carList.getCarLinkedList());

        carList.populateListWithObjects();

        carList.removeItem(3);

        carList.listItems(carList.getCarLinkedList());

        boolean quit = false;
        int choice = 0;
        printinstructions();

        while (!quit) {
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine(); //clear the input buffer

            switch (choice) {
                case 0:
                    printinstructions();
                    break;
                case 1:
                    listItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    System.out.println("Exit switch!");
                    quit = true;
                    break;
            }
        }
    }
}
