package com.sherbansoftware;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {

    private List<String> groceryList = new ArrayList<>();

    public List<String> getGroceryList() {
        return groceryList;
    }

    public void addItem(List list, String item) {
        list.add(item);
    }

    public void printList(List list) {
        System.out.println("You have " + list.size() + " elements in your list");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element " + i + " is: " + list.get(i));
        }
    }

    public List modifyItem(List list, int position, String newItem) {
        list.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified");
        return list;
    }

    public List removeItem(List list, int position) {
        list.remove(position);
        System.out.println("Grocery item " + (position + 1) + " has been removed");
        return list;
    }

    public String findItem(String searchItem) {
        boolean exists = groceryList.contains(searchItem);

        if (exists) {
            int position = groceryList.indexOf(searchItem);
            System.out.println("Item found at index: " + position);
            return groceryList.get(position);
        } else {
            System.out.println("Grocery item does not exist");
        }
        return "Not found";
    }
}
