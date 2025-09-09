/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.seriesapplication;

import java.util.Scanner;

/**
 *
 * @author sadaw
 */
public class SeriesApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String option;

        // intro prompt
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit.");

        option = sc.nextLine();

        if (!option.equals("1")) {
            System.out.println("Exiting...");
            return;
        }

        // loop for menu
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report – 2025");
            System.out.println("(6) Exit Application.");

            option = sc.nextLine();

            switch (option) {
                case "1":
                    Series.CaptureSeries();
                    break;
                case "2":
                    Series.SearchSeries();
                    break;
                case "3":
                    Series.UpdateSeries();
                    break;
                case "4":
                    Series.DeleteSeries();
                    break;
                case "5":
                    Series.SeriesReport();
                    break;
                case "6":
                    Series.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

            System.out.println("Enter (1) to launch menu or any other key to exit.");
            String agn = sc.nextLine();
            if (!agn.equals("1")) {
                Series.ExitSeriesApplication();
            }
        }
    }
}
