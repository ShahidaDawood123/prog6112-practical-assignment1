/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sadaw
 */
// the class stores tv series details and methods
class Series {

    // fields to keep series details
    String seriesID;
    String seriesName;
    int seriesAge;
    int seriesNumberofEpisodes;

    // list to store all captured series in memory
    static ArrayList<Series> seriesList = new ArrayList<>();

    // scanner for user input
    static Scanner sc = new Scanner(System.in);

    // capture a new series
    public static void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("********************************");

        System.out.println("Enter the series ID: ");
        String id = sc.nextLine();

        System.out.println("Enter the series name: ");
        String name = sc.nextLine();

           /*
    Title: Loops and iteration
    Author: Mozilla
    Date: 07-09-2025
    Code Version: Java 8
    Availability: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Loops_and_iteration
    */
        // validate series age restriction 
        int age = -1;
        while (age < 2 || age > 18) {
            System.out.print("Enter the series age restriction (2–18): ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                sc.nextLine(); // clear buffer
                if (age < 2 || age > 18) {
                    System.out.println("You have entered an incorrect series age!");
                }
            } else {
                System.out.println("You have entered an incorrect series age!");
                sc.next(); // discard invalid input
            }
        }

        // get number of episodes
        int episodes = -1;
        while (episodes <= 0) {
            System.out.print("Enter the number of episodes: ");
            if (sc.hasNextInt()) {
                episodes = sc.nextInt();
                sc.nextLine(); // clear buffer
                if (episodes <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                sc.next(); // discard invalid input
            }
        }

        // a new series obj and add to the list
        Series set = new Series();
        set.seriesID = id;
        set.seriesName = name;
        set.seriesAge = age;
        set.seriesNumberofEpisodes = episodes;

        seriesList.add(set);
        System.out.println("Series processed successfully!");
    }

    // search for series by ID
    public static void SearchSeries() {
        System.out.println("Enter the series ID to search: ");
        String id = sc.nextLine();

        boolean found = false;
        for (Series set : seriesList) {
            if (set.seriesID.equals(id)) {
                System.out.println("SERIES ID: " + set.seriesID);
                System.out.println("SERIES NAME: " + set.seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + set.seriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + set.seriesNumberofEpisodes);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series with series ID: " + id + " was not found.");
        }
    }

    // update a series by ID
    public static void UpdateSeries() {
        System.out.println("Enter the series ID to update: ");
        String id = sc.nextLine();

        boolean found = false;
        for (Series set : seriesList) {
            if (set.seriesID.equals(id)) {
                System.out.print("Enter the series name: ");
                set.seriesName = sc.nextLine();

                // Validate age restriction again
                int age = -1;
                while (age < 2 || age > 18) {
                    System.out.print("Enter the age restriction (2–18): ");
                    if (sc.hasNextInt()) {
                        age = sc.nextInt();
                        sc.nextLine();
                        if (age < 2 || age > 18) {
                            System.out.println("You have entered an incorrect series age!");
                        }
                    } else {
                        System.out.println("You have entered an incorrect series age!");
                        sc.next();
                    }
                }
                set.seriesAge = age;

                // Number of episodes
                int episodes = -1;
                while (episodes <= 0) {
                    System.out.print("Enter the number of episodes: ");
                    if (sc.hasNextInt()) {
                        episodes = sc.nextInt();
                        sc.nextLine();
                        if (episodes <= 0) {
                            System.out.println("Please enter a positive number.");
                        }
                    } else {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }
                set.seriesNumberofEpisodes = episodes;

                System.out.println("Series updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series with Series ID: " + id + " was not found!");
        }
    }

    // delete a series by ID
    public static void DeleteSeries() {
        System.out.print("Enter the series ID to delete: ");
        String id = sc.nextLine();

        Series toDelete = null;
        for (Series set : seriesList) {
            if (set.seriesID.equals(id)) {
                toDelete = set;
                break;
            }
        }

        if (toDelete != null) {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes to delete: ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("Yes")) {
                seriesList.remove(toDelete);
                System.out.println("Series with Series ID: " + id + " was deleted!");
            } else {
                System.out.println("Delete cancelled.");
            }
        } else {
            System.out.println("Series with Series ID: " + id + " was not found!");
        }
    }

    // print a report of all series
    public static void SeriesReport() {
        int count = 1;
        for (Series set : seriesList) {
            System.out.println("Series " + count);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("SERIES ID: " + set.seriesID);
            System.out.println("SERIES NAME: " + set.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + set.seriesAge);
            System.out.println("NUMBER OF EPISODES: " + set.seriesNumberofEpisodes);
            System.out.println("-------------------------------------------------------------------------------");
            count++;
        }
        if (seriesList.isEmpty()) {
            System.out.println("No series found in the system!");
        }
    }

    // exit the application
    public static void ExitSeriesApplication() {
        System.out.println("Exiting application. Bye!");
        System.exit(0);
    }

    // non-interactive methods
    public boolean captureSeries(String id, String name, int age, int episodes) {
     // validate series ID, series name, age restriction and number of episodes
        if (id == null || id.isEmpty()) {
            return false;
        }
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (age < 2 || age > 18) {
            return false;
        }
        if (episodes <= 0) {
            return false;
        }

        // check for duplicate IDs to ensure its different
        for (Series s : seriesList) {
            if (s.seriesID.equals(id)) {
                return false; // duplicate ID
            }
        }

        // new series obj 
        Series set = new Series();
        set.seriesID = id;
        set.seriesName = name;
        set.seriesAge = age;
        set.seriesNumberofEpisodes = episodes;
      
        seriesList.add(set);
        return true;
    }

    // loop for series in the list
    public String searchSeries(String id) {
        for (Series s : seriesList) {
            if (s.seriesID.equals(id)) {
                return "SERIES ID: " + s.seriesID + "\n"
                        + "SERIES NAME: " + s.seriesName + "\n"
                        + "SERIES AGE RESTRICTION: " + s.seriesAge + "\n"
                        + "SERIES NUMBER OF EPISODES: " + s.seriesNumberofEpisodes;
            }
        }
        return "Series with Series Id: " + id + " was not found!";
    }

    // validate new name, new age restriction, new number of episodes
    public boolean updateSeries(String id, String newName, int newAge, int newEpisodes) {
        if (newName == null || newName.isEmpty()) {
            return false;
        }
        if (newAge < 2 || newAge > 18) {
            return false;
        }
        if (newEpisodes <= 0) {
            return false;
        }

        // loop series list to find series to update
        for (Series s : seriesList) {
            if (s.seriesID.equals(id)) {
                s.seriesName = newName;
                s.seriesAge = newAge;
                s.seriesNumberofEpisodes = newEpisodes;
                return true;
            }
        }
        return false;
    }

    // loop series list to fing the series to delete
    public boolean deleteSeries(String id) {
        for (Series s : seriesList) {
            if (s.seriesID.equals(id)) {
                seriesList.remove(s);
                return true;
            }
        }
        return false;
    }
}
