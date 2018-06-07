package com.sherbansoftware;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); //autoboxing coverts the primitive value in a object
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        printDoubles(list);

        Cat cat = new Cat("cat");
        Dog dog = new Dog("dog");

        //allows any type of animal to be added in the farm
        Farm farm = new Farm("Multiple Animals Farm Name");
        farm.addAnimal(cat);
        farm.addAnimal(dog);

        System.out.println("Size of farm is: " + farm.farmMembersNumber());

        //ensure only cats are added to farm using generics without duplicating code
        Cat firstCat = new Cat("first cat");
        Cat secondCat = new Cat("second cat");
        Farm<Cat> farm1 = new Farm<>("Cat Animals Farm Name 1");
        farm1.addAnimal(firstCat);
        farm1.addAnimal(secondCat);

        farm1.checkLifeStatus(farm, 1 , 0);

        //ensure only dogs are added to farm using generics without duplicating code
        Dog firstDog = new Dog("first dog");
        Dog secondDog = new Dog("second dog");
        Farm<Dog> farm2 = new Farm<>("Dog Animals Farm Name");
        farm2.addAnimal(firstDog);
        farm2.addAnimal(secondDog);

        farm1.checkLifeStatus(farm2, 3, 7);
    }

    private static void printDoubles(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();

        //traversing using interator
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key * 2);
        }
        System.out.println("=========");
        //traversing using foreach
        for (Integer key : list) {
            System.out.println(key * 4);
        }

    }


}
