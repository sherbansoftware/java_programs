package com.sherbansoftware.controller;

import com.sherbansoftware.model.StudentModel;
import com.sherbansoftware.view.StudentView;

/*
Controllers are the most difficult part.
They receive a =request= from the user, decide what to do, and then send a =response= back.
It's the only component that interacts with the model and the view.
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
