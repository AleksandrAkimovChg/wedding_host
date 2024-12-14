package com.javaacademy.wedding_host.mapper;

import com.javaacademy.wedding_host.dto.BookingDtoReq;
import com.javaacademy.wedding_host.dto.BookingMonthDtoRes;
import com.javaacademy.wedding_host.dto.MonthCountDtoRes;
import com.javaacademy.wedding_host.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {

    public BookingMonthDtoRs convertToBookingMonthDto(Booking booking) {
        return new BookingMonthDtoRs(booking.getMonthNumber(), booking.getDayNumber(), booking.getIsBooked());
    }

    public Booking convertToBooking(BookingDtoRq bookingDtoReq, boolean isBooked) {
        return new Booking(bookingDtoReq.getMonth(), bookingDtoReq.getDay(), isBooked);
    }

    public MonthCountDtoRs convertToMonthCountDtoRes(int count) {
        return new MonthCountDtoRs(count);
    }
}
