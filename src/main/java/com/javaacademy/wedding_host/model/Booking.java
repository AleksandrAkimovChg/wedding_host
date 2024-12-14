package com.javaacademy.wedding_host.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Booking {
    private UUID uuid;
    private Integer monthNumber;
    private Integer dayNumber;
    private Boolean isBooked;

    public Booking(@NonNull Integer monthNumber, @NonNull Integer dayNumber, Boolean isBooked) {
        this.monthNumber = monthNumber;
        this.dayNumber = dayNumber;
        this.isBooked = isBooked;
    }
}
