/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapp;

/**
 *
 * @author sadaw
 */
public class SchoolTask extends Task {

    //subject name
    private String subject;

    //constructor
    public SchoolTask(String title, String dueDate, String subject) {
        super(title, dueDate);
        this.subject = subject;
    }

    @Override
    public String getTaskReport() {
        return super.getTaskReport() + " | Subject: " + subject + " (School)";
    }
    
}
