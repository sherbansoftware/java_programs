package com.sherbansoftware;

/**
 * Java array is an object the contains elements of similar data type. It is a data structure where we store similar elements. We can store only fixed set of elements in a java array.
 * Eg. array of characters, array of integer, array of String, array of SomeObject
 */
public class Main {
    private static CarList carList = new CarList();

    // static method which return the average of array elements
    public static double getAvgOfArrElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / (double) arr.length;
    }

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
        carList.addItem(new Car("Dacia", "1310"));
        carList.addItem(new Car("Dacia", "Sandero"));
        carList.addItem(new Car("Dacia", "Logan"));
        carList.addItem(new Car("Dacia", "Logan MCV"));
        Car findCar = new Car("Dacia", "Dokker");
        carList.addItem(findCar);
        carList.addItem(new Car("Dacia", "Lodgy"));


        carList.modifyItem(0, new Car("Dacia", "Berlina"));

        carList.findItem(findCar);

        carList.listItems(carList.getCarLinkedList());

        carList.populateArrayList();

        carList.listItems(carList.getCarArrayList());
    }
}
