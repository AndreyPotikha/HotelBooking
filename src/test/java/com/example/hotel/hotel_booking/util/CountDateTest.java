package com.example.hotel.hotel_booking.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CountDateTest {

    private CountDate runner;

    @Before
    public void setUp() throws Exception {
        runner = new CountDate();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("All done");
    }

    @Test
    public void countDate() {
        String arrival = "2018-03-05";
        String departure = "2018-03-08";
        assertEquals(3, runner.countDate(arrival, departure));
    }

}