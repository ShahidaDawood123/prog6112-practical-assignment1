/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.todoapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sadaw
 */
public class TaskTest {
    
   @Test
    public void testSchoolTaskReport() {
        
        //test that task class stores title and due date correctly
        SchoolTask task1 = new SchoolTask("Science Assignment", "2025-09-10", "Science");
        String report = task1.getTaskReport();
        assertTrue(report.contains("Science Assignment"));
        assertTrue(report.contains("2025-09-10"));
        assertTrue(report.contains("Science"));
    }

    // test that schooltask includes subject in details
    @Test
    public void testPersonalTaskReport() {
        PersonalTask task2 = new PersonalTask("Buy Groceries", "2025-09-11", true);
        String report = task2.getTaskReport();
        assertTrue(report.contains("Buy Groceries"));
        assertTrue(report.contains("2025-09-11"));
        assertTrue(report.contains("Yes"));
    }

    // test that personaltask with urgent shows correct details
    @Test
    public void testGetters() {
        Task task3 = new Task("Business Report", "2025-09-15");
        assertEquals("Business Report", task3.getTitle());
        assertEquals("2025-09-15", task3.getDueDate());
    }
}