package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingMonthDtoRes {
    private int monthNumber;
    private int dayNumber;
    private Boolean booked;
}
