package com.sherbansoftware;
// simulating the animals fighting on a farm

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Farm<T extends Animal & IAnimal> implements Comparable<Farm<T>> {
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

    public boolean addAnimal(T animal) {
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

    public void showFarmTable(){
        //Collections.sort(farmMembers);

        for (T t : farmMembers)
            System.out.println(" Animal name: " + t.getName() + " ranking: " + this.ranking() );
    }

    public int getFarmMembersNumber() {
        return this.farmMembers.size();
    }

    public String checkLifeStatus(Farm<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            won++;
            message = "won";
        } else if (ourScore < theirScore) {
            lost++;
            message = "lost";
        } else {
            tied++;
            message = "tied";
        }
        played++;
        if (opponent != null) {
            System.out.println(this.getFarmName() + " " + message + " " + opponent.getFarmName());
            opponent.checkLifeStatus(null, theirScore, ourScore);
        }

        return message;
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Farm<T> farm) {
        if (this.ranking() > farm.ranking()) {
            return -1;
        } else if (this.ranking() < farm.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
