package com.sherbansoftware.view;

/*
Views are what the user sees on screen.
They present the data to the user.
They know nothing about the models

View objects represent something visible in the user interface, for example a panel or button.
In order to display the data from the model objects you might want to create your own custom objects,
like a graph for example.
 */
public class StudentView {
    public void printStudentDetails(String studentName, Integer studentIdCardNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Id card: " + studentIdCardNo);
    }
}
