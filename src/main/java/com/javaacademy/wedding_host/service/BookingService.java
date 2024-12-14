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
    public List<BookingMonthDtoRs> getBookedDaysInMonth(@NonNull Integer month) {
        return bookingRepository.getBookingDaysInMonth(month).stream()
                .map(mapper::convertToBookingMonthDto).toList();
    }

    /**
     * Сохраняет новое бронирование
     */
    public void createBooking(BookingDtoRq bookingDto) {
        bookingRepository.save(mapper.convertToBooking(bookingDto, false));
    }

    /**
     * Возвращает для фронта количество всех бронирований
     */
    public MonthCountDtoRs countBookedDaysInMonth(Integer month) {
        return mapper.convertToMonthCountDtoRes(bookingRepository.getBookingDaysInMonth(month).size());
    }
}
