package com.sherbansoftware.view;

/*
Views are what the user sees on screen.
They present the data to the user.
They know nothing about the models
 */
public class StudentView {
    public void printStudentDetails(String studentName, Integer studentIdCardNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Id card: " + studentIdCardNo);
    }
}
