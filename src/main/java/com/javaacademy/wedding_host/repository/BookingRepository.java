package com.javaacademy.wedding_host.repository;

import com.javaacademy.wedding_host.model.Booking;
import com.javaacademy.wedding_host.storage.BookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BookingRepository {
    private final BookingStorage storage;

    /**
     * Получение списка обо всех бронированиях в месяце
     */
    public List<Booking> getBookingDaysInMonth(int month) {
        return storage.getData().values().stream()
                .filter(e -> e.getMonthNumber() == month).toList();
    }

    /**
     * Сохранения бронирования
     */
    public void save(Booking booking) {
        if (isDayBooked(booking.getMonthNumber(), booking.getDayNumber())) {
            throw new RuntimeException("День уже забронирован");
        }
        booking.setUuid(UUID.randomUUID());
        storage.save(booking);
    }

    /**
     * Проверка дня бронирования
     */
    private boolean isDayBooked(Integer month, Integer day) {
        return storage.getData().values().stream()
                .anyMatch(e -> e.getMonthNumber() == month && e.getDayNumber() == day);
    }
}
