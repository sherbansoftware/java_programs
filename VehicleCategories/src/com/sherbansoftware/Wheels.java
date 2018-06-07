package com.sherbansoftware;

import java.util.Optional;

/**
 * Created by Mihai Serban on 9/16/2017.
 */
public class Wheels {
    private Optional<Number> number = Optional.ofNullable(4);

    public Optional<Number> getNumber() {
        return number;
    }

    public void setNumber(Optional<Number> number) {
        this.number = number;
    }
}
