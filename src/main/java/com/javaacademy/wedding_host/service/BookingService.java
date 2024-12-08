package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.BookingDtoReq;
import com.javaacademy.wedding_host.dto.BookingMonthDtoRes;
import com.javaacademy.wedding_host.dto.MonthCountDtoRes;
import com.javaacademy.wedding_host.mapper.BookingMapper;
import com.javaacademy.wedding_host.repository.BookingRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;

    /**
     * Возвращает для фронта список всех бронирований
     */
    public List<BookingMonthDtoRes> getBookedDaysInMonth(@NonNull Integer month) {
        return bookingRepository.getBookingDaysInMonth(month).stream()
                .map(mapper::convertToBookingMonthDto).toList();
    }

    /**
     * Сохраняет новое бронирование
     */
    public void createBooking(BookingDtoReq bookingDto) {
        bookingRepository.save(mapper.convertToBooking(bookingDto, true));
    }

    /**
     * Возвращает для фронта количество всех бронирований
     */
    public MonthCountDtoRes countBookedDaysInMonth(Integer month) {
        return mapper.convertToMonthCountDtoRes(bookingRepository.getBookingDaysInMonth(month).size());
    }
}
