/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapp;

/**
 *
 * @author sadaw
 */
public class Task {
    
    // task title and due date 
    private String title;
    private String dueDate;
    
    // constructor
    public Task(String title, String dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }
    
    // getters 
    public String getTitle() {
        return title;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    //report format
    public String getTaskReport() {
        return "Task: " + title + " | Due: " + dueDate;
    }
    
}
