package com.sherbansoftware.controller;

import com.sherbansoftware.model.StudentModel;
import com.sherbansoftware.view.StudentView;

/*
Controllers are the most difficult part.
They receive a =request= from the user, decide what to do, and then send a =response= back.
It's the only component that interacts with the model and the view.

The Controller object acts as a Mediator between the Model and View objects.
A Controller object communicates data back and forth between the Model objects and the View objects.
For example a controller could mediate the first name of a student from a model object
to a visible text field in the User Interface.
A controller also performs all application specific tasks, such as processing user input or loading
configuration data.
There is usually one controller per application or window, in many applications the Controller is tightly coupled to the view.
The Basic sample application shows this - every GUI class implements its own ActionListeners.
Since controllers are application specific they usually do not find any reuse in other applications.
 */
public class StudentController {
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController(StudentModel studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    public void setStudentName(String name) {
        studentModel.setName(name);
    }

    public String getStudentName() {
        return studentModel.getName();
    }

    public void setStudentIdCardNo(Integer idCard) {
        studentModel.setIdCard(idCard);
    }

    public Integer getStudentIdCard() {
        return studentModel.getIdCard();
    }

    public void updateView() {
        studentView.printStudentDetails(studentModel.getName(), studentModel.getIdCard());
    }
}
