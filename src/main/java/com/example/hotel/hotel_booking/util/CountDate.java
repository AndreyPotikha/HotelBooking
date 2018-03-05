package com.example.hotel.hotel_booking.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CountDate {

    public int countDate(String arrival, String departure) {
        System.out.println(arrival);

        LocalDate arrivalDate = LocalDate.parse(arrival);
        LocalDate departureDate = LocalDate.parse(departure);

        int resultDays = (int) ChronoUnit.DAYS.between(departureDate, arrivalDate);
        resultDays *= -1;

        return resultDays;
    }

}
