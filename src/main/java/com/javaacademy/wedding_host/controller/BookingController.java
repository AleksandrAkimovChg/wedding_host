package com.javaacademy.wedding_host.controller;

import com.javaacademy.wedding_host.dto.BookingDtoReq;
import com.javaacademy.wedding_host.dto.BookingMonthDtoRes;
import com.javaacademy.wedding_host.dto.MonthCountDtoRes;
import com.javaacademy.wedding_host.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {
    private final BookingService bookingService;

    /**
     * Данные о бронированиях за этот месяц
     */
    @GetMapping("/month/{monthNumber}")
    public List<BookingMonthDtoRs> getBookingMonth(@PathVariable Integer monthNumber) {
        log.debug("/month/{monthNumber} input: {}", monthNumber);
        return bookingService.getBookedDaysInMonth(monthNumber);
    }

    /**
     * Новое бронирование
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void booking(@RequestBody BookingDtoRq bookingDto) {
        log.debug("bookingDto input: {}", bookingDto);
        bookingService.createBooking(bookingDto);
    }

    /**
     * Количество забронированных дней за этот выбранный месяц
     */
    @GetMapping("/month/{monthNumber}/free")
    public MonthCountDtoRs getCountBookedDaysInMonth(@PathVariable Integer monthNumber) {
        log.debug("/month/{monthNumber}/free input: {}", monthNumber);
        return bookingService.countBookedDaysInMonth(monthNumber);
    }
}
