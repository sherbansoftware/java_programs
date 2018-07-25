package com.sherbansoftware.model;

/*
Models are where application data are stored: database, files, etc.
They are responsible for retrieving and storing data.
They know nothing about the view or user interface.

Model objects hold data and define the logic for manipulating that data.
For example, a Student object in the Basic sample application is a model object.
It holds data describing facts about the object like the first and last name of
the student and has methods that can access and change this data (getters & setters).
 Model objects are not directly displayed. They often are reusable, distributed,
 persistent and portable to a variety of platforms.
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
