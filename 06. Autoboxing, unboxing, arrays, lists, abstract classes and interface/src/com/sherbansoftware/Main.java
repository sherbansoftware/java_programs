package com.sherbansoftware;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Java array is an object the contains elements of similar data type. It is a data structure where we store similar elements. We can store only fixed set of elements in a java array.
 * Eg. array of characters, array of integer, array of String, array of SomeObject
 */
public class Main {
    private final static String TAG = Main.class.getSimpleName();

    //define a List of cars which has it s size allocated dynamically
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
    private static void populateListWithHardcodedData() {
        carList.populateListWithHardcodedObjects();
    }

    private static void listItems() {
        //list Collection Items
        carList.listItems(carList.getCarLinkedList());
    }

    private static void addData() {
        System.out.print("Enter a car manufacturer to be added: ");
        String carManufacturer = scanner.nextLine();
        System.out.print("Enter a car model to be added: ");
        String carModel = scanner.nextLine();
        Car carToBeAdded = new Car(carManufacturer, carModel);
        carList.addNewItem(carToBeAdded); //one way
        carList.addNewItem(carManufacturer, carModel); //second way
    }

    private static void updateData() {
//        System.out.print("Enter item number to be modified: ");
//        int itemNo = scanner.nextInt();
//        scanner.nextLine();

        //Car carToBeModified = new Car("Manufacturer to be modified", "Model to be modified");
        //Note that for the user should not use an index to access particular elements in order to modify a car item. Just as example.
        //carList.updateItem(itemNo - 1, carToBeModified);  // //call to modify a car based on it's index
        // System.out.println();
        //carList.updateItem(new Car("Dacia", "Berlina")); //call to modify a specific car
        Car oldCar = new Car("Dacia", "1310");
        Car newCar = new Car("Daciaxx", "Berlinaxxx");
        carList.updateItem(oldCar, newCar);
    }

    private static void removeData() {
        System.out.print("Enter a car manufacturer to be deleted: ");
        String carManufacturerToBeDeleted = scanner.nextLine();
        System.out.print("Enter a car model to be deleted: ");
        String carModelToBeDeleted = scanner.nextLine();
        //Note that for the user should not use an index to access particular elements in order to remove a car item. Just as example.
        carList.removeItem(carManufacturerToBeDeleted, carModelToBeDeleted);  //call to remove a specific car
        //carList.removeItem(carList.getCarLinkedList(), 1, 3); //call to remove specific indexes
    }


    private static void searchForItem() {
        System.out.print("Enter a car manufacturer to be searched: ");
        String carManufacturer = scanner.nextLine();
        System.out.print("Enter a car model to be searched: ");
        String carModel = scanner.nextLine();

        carList.searchForItem(carManufacturer, carModel);

    }

    private static void boxingAndUnboxing() {
        Integer[] integerArray = new Integer[5]; // create integerArray
        integerArray[0] = 10; // assign Integer 10 to integerArray[0]
        int value = integerArray[0]; // get int value of Integer
        System.out.println(integerArray.getClass());
        System.out.println(value);
    }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of car items within the list.");
        System.out.println("\t 2 - To populate list with hardcoded data.");
        System.out.println("\t 3 - To add a new car item to the list.");
        System.out.println("\t 4 - To update an existing car item in the list.");
        System.out.println("\t 5 - To delete a car item from the list.");
        System.out.println("\t 6 - To search for a car item in the list.");
        System.out.println("\t 7 - To quit the application.");
    }

    //Entry point for JVM
    public static void main(String[] args) {
        //do Grocery Stuff
        doGroceryStuff();

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

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                e = new InputMismatchException("Incorrect option. Press 0 to print choice options");
                System.out.println(e.getMessage());
            }
            scanner.nextLine(); //clear the input buffer

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    listItems();
                    break;
                case 2:
                    populateListWithHardcodedData();
                    break;
                case 3:
                    addData();
                    break;
                case 4:
                    updateData();
                    break;
                case 5:
                    removeData();
                    break;
                case 6:
                    searchForItem();
                    break;
                case 7:
                    System.out.println("Exit switch!");
                    quit = true;
                    break;
            }
        }
    }

    public static void initializeArray(int[] arr) {
        System.out.println(TAG + " initializeArray");
        for (int i = 0; i < arr.length; i++) {
            arr[i] += i * 20;
            System.out.println("Element " + i + " value is: " + arr[i]);
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(TAG + " printArray");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element " + i + " value is: " + arr[i]);
        }
    }

    public static double getAverage(int[] arr) {
        System.out.println(TAG + " getAverage");
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("Sum is: " + sum);
        return (double) sum / (double) arr.length;
    }

    public static int[] sortArrayIntegers(int[] arr) {
        System.out.println(TAG + " sortArrayIntegers");
        int[] sortedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArray[i] = arr[i];
        }

        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static int[] sortArrayIntegersUsingCopyOf(int[] arr) {
        System.out.println(TAG + " sortArrayIntegersUsingCopyOf");
        int[] sortedArray = Arrays.copyOf(arr, arr.length);

        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    private static int[] resizeArray(int[] arr, int length) {
        int[] originalArr = arr;
        arr = new int[length];
        for (int i = 0; i < originalArr.length; i++) {
            arr[i] = originalArr[i];
        }
        return arr;
    }

    public static void doGroceryStuff() {
        int[] myArrayVariables = new int[3];
        printArray(myArrayVariables);
        initializeArray(myArrayVariables);
        double avg = getAverage(myArrayVariables);
        System.out.println("AVG is: " + avg);
        int[] sortedIntegers = sortArrayIntegers(myArrayVariables);
        printArray(sortedIntegers);
        sortedIntegers = sortArrayIntegersUsingCopyOf(myArrayVariables);
        printArray(sortedIntegers);
        int[] resizedArr = resizeArray(myArrayVariables, 5);
        printArray(resizedArr);

        GroceryList groceryList = new GroceryList();
        List listOfItems = groceryList.getGroceryList();
        groceryList.addItem(listOfItems, "Apples");
        groceryList.addItem(listOfItems, "Bread");
        groceryList.addItem(listOfItems, "Cakes");
        groceryList.printList(listOfItems);
        List newListOfItems = groceryList.modifyItem(listOfItems, 0, "Kiwis");
        groceryList.printList(newListOfItems);
        newListOfItems = groceryList.removeItem(newListOfItems, 0);
        groceryList.printList(newListOfItems);
        System.out.println(groceryList.findItem("Bread").toUpperCase());
    }
}
