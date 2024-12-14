package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingMonthDtoRs {
    private Integer monthNumber;
    private Integer dayNumber;
    private Boolean booked;
}
