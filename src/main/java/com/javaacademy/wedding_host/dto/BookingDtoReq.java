package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDtoReq {
    private int month;
    private int day;
}