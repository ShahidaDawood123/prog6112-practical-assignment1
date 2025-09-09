/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapp;

/**
 *
 * @author sadaw
 */
public class PersonalTask extends Task {

    // if the task is urgent or not
    private boolean urgent;

    //constructor
    public PersonalTask(String title, String dueDate, boolean urgent) {
        super(title, dueDate);
        this.urgent = urgent;
    }

    @Override
    public String getTaskReport() {
        return super.getTaskReport() + " | Urgent: " + (urgent ? "Yes" : "No") + "(Personal)";
    }

}
