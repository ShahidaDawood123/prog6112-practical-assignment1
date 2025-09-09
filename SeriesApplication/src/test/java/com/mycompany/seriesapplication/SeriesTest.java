/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.seriesapplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sadaw
 */
public class SeriesTest {
    
  // 1. Test searching for a series that exists
    @Test
    public void TestSearchSeries() {
        Series seriesApp = new Series();
        seriesApp.captureSeries("103", "Home Cooking", 10, 20);

        String result = seriesApp.searchSeries("103");

        // It should return details containing the series name
        assertTrue(result.contains("Home Cooking"));
    }

    // 2. Test searching for a series that does not exist
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series seriesApp = new Series();

        String result = seriesApp.searchSeries("999");

        assertEquals("Series with Series Id: 999 was not found!", result);
    }

    // 3. Test deleting a series that exists
    @Test
    public void TestDeleteSeries() {
        Series seriesApp = new Series();
        seriesApp.captureSeries("103", "Home Cooking", 10, 20);

        boolean deleted = seriesApp.deleteSeries("103");

        assertTrue(deleted);
        assertEquals("Series with Series Id: 103 was not found!", seriesApp.searchSeries("103"));
    }

    // 4. Test deleting a series that does not exist
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series seriesApp = new Series();

        boolean deleted = seriesApp.deleteSeries("888");

        assertFalse(deleted);
    }

    // 5. Test valid age restriction is accepted
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        Series seriesApp = new Series();

        boolean inserted = seriesApp.captureSeries("104", "Valid Show", 15, 5);

        assertTrue(inserted);
    }

    // 6. Test invalid age restriction is rejected
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        Series seriesApp = new Series();

        boolean insertedLow = seriesApp.captureSeries("105", "Invalid Show Low", 1, 5);
        boolean insertedHigh = seriesApp.captureSeries("106", "Invalid Show High", 20, 5);

        assertFalse(insertedLow);
        assertFalse(insertedHigh);
    }
}