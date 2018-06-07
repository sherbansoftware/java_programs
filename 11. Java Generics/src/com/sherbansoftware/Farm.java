package com.sherbansoftware;
// simulating the animals fighting on a farm

import java.util.ArrayList;
import java.util.List;

public class Farm<T extends Animal & IAnimal> {
    private String farmName;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private List<T> farmMembers = new ArrayList<>();

    public Farm(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmName() {
        return farmName;
    }

    public boolean addAnimal(T animal ) {
        if (farmMembers.contains(animal)) {
            //redundant casting because of generic extend class
            System.out.println("Animal: " + ((Animal) animal).getName() + " is already in farm");
            return false;
        } else {
            farmMembers.add(animal);
            System.out.println("Animal: " + animal.getName() + " added in farm: " + this.getFarmName());
            return true;
        }
    }

    public int farmMembersNumber() {
        return this.farmMembers.size();
    }

    public void checkLifeStatus(Farm opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore < theirScore) {
            lost++;
        } else {
            tied++;
        }
        played++;
        if (opponent != null) {
            opponent.checkLifeStatus(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }
}
