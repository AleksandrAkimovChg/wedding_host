package com.javaacademy.wedding_host.mapper;

import com.javaacademy.wedding_host.dto.BookingDtoReq;
import com.javaacademy.wedding_host.dto.BookingMonthDtoRes;
import com.javaacademy.wedding_host.dto.MonthCountDtoRes;
import com.javaacademy.wedding_host.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {

    public BookingMonthDtoRes convertToBookingMonthDto(Booking booking) {
        return new BookingMonthDtoRes(booking.getMonthNumber(), booking.getDayNumber(), booking.getIsBooked());
    }

    public Booking convertToBooking(BookingDtoReq bookingDtoReq) {
        return new Booking(bookingDtoReq.getMonth(), bookingDtoReq.getDay(), true);
    }

    public MonthCountDtoRes convertToMonthCountDtoRes(int count) {
        return new MonthCountDtoRes(count);
    }
}
