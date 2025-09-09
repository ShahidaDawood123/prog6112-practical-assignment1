/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todoapp;

import java.util.Scanner;

/**
 *
 * @author sadaw
 */
public class ToDoApp {
    
    // array holdinf up to 20 tasks
    private static Task[] tasks = new Task[20];
    private static int count = 0;

    public static void main(String[] args) {
     Scanner sc = new Scanner (System.in);
     int option;
     
     // loops until user exits
     do {
         System.out.println("\n*** Student To-Do List App ***");
         System.out.println("1. Add School Task");
         System.out.println("2. Add Personal Task");
         System.out.println("3. View all Tasks");
         System.out.println("4. Delete Task by Title");
         System.out.println("5. Exit");
         System.out.println("Enter option: ");
         option = sc.nextInt();
         sc.nextLine();
         
         //differents options
         switch (option) {
             case 1:
                 addSchoolTask(sc);
                 break;
             case 2:
                 addPersonalTask(sc);
                 break;
             case 3:
                 viewTasks();
                 break;
             case 4:
                 deleteTask(sc);
                 break;
             case 5:
                 System.out.println("Goodbye! Keep up the work.");
                 break;
             default: 
                 System.out.println("Invalid option, please try again.");
     }
    } while (option !=5);
     
     sc.close();
}
     // method to add school task
    private static void addSchoolTask(Scanner sc) {
        if (count >= tasks.length) {
            System.out.println("Task list is full.");
            return;
        }
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = sc.nextLine();
        System.out.print("Enter subject: ");
        String subject = sc.nextLine();

        tasks[count++] = new SchoolTask(title, dueDate, subject);
        System.out.println("School task added.");
    }

    // method  to add personal task
    private static void addPersonalTask(Scanner sc) {
        if (count >= tasks.length) {
            System.out.println("Task list is full.");
            return;
        }
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = sc.nextLine();
        System.out.print("Is it urgent? (true/false): ");
        boolean urgent = sc.nextBoolean();
        sc.nextLine(); // consume newline

        tasks[count++] = new PersonalTask(title, dueDate, urgent);
        System.out.println("Personal task added.");
    }

    // method to view all tasks
    private static void viewTasks() {
        if (count == 0) {
            System.out.println("No tasks added yet.");
            return;
        }
        System.out.println("\n*** Task Report ***");
        for (int i = 0; i < count; i++) {
            System.out.println(tasks[i].getTaskReport());
        }
    }

    // method to delete task by title
    private static void deleteTask(Scanner sc) {
        if (count == 0) {
            System.out.println("No tasks to delete.");
            return;
        }
        System.out.print("Enter task title to delete: ");
        String title = sc.nextLine();
        boolean found = false;
        
    /*
    Title: Loops and iteration
    Author: Mozilla
    Date: 07-09-2025
    Code Version: Java 8
    Availability: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Loops_and_iteration
    */
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTitle().equalsIgnoreCase(title)) {
                // shift array to fill the space
                for (int j = i; j < count - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[count - 1] = null;
                count--;
                found = true;
                System.out.println("Task deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found.");
        }
    }
}
