package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDtoRq {
    private Integer month;
    private Integer day;
}
