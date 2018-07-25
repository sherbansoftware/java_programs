package com.sherbansoftware;

import com.sherbansoftware.controller.StudentController;
import com.sherbansoftware.model.StudentModel;
import com.sherbansoftware.view.StudentView;

public class MVCPattenEntryPoint {

    /*
    MVC steps:
    1. create models
    2. create view
    3. create controllers
     */
    public static void main(String[] args) {

        //fetch student record based on his idCardNo from the files or database
        StudentModel model = retriveStudentFromDatabase();

        //Create a view : to write student details on console (view).
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //controller updates the model data
        controller.setStudentName("John");
        controller.setStudentIdCardNo(190191010);

        controller.updateView();
    }

    private static StudentModel retriveStudentFromDatabase() {
        StudentModel student = new StudentModel();
        student.setName("Robert");
        student.setIdCard(1094756730);
        return student;
    }
}

