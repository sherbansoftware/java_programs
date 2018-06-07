package com.sherbansoftware;

import java.util.Optional;

/**
 * Created by Mihai Serban on 9/16/2017.
 */
public class Engine {
    private Optional<Integer> rpms;

    public Optional<Integer> getRpms() {
        return rpms;
    }

    public Engine(Optional<Integer> rpms) {
        this.rpms = rpms;
    }

    private void setRpms(Integer rpms) {
        if(this.getRpms().isPresent()){
            Integer value = this.getRpms().get();
            Optional<Integer> optional = Optional.ofNullable(value);
        }
    }

    public void increaseRpms(int number){
        this.setRpms(number);
    }

    public void decreaseRpms(Number number){
        this.setRpms(number.intValue());
    }

}
