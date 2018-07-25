package com.sherbansoftware.model;

/*
Models are where application data are stored: database, files, etc.
They are responsible for retrieving and storing data.
They know nothing about the view or user interface.
 */
public class StudentModel {
    private Integer idCard;
    private String name;

    public Integer getIdCard() {

        return idCard;
    }

    public String getName() {
        return name;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public void setName(String name) {
        this.name = name;
    }


}
