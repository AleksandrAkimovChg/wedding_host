package com.javaacademy.wedding_host.repository;

import com.javaacademy.wedding_host.model.Booking;
import com.javaacademy.wedding_host.storage.BookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

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
        if (isDayBooked(booking)) {
            throw new RuntimeException("День уже забронирован");
        }
        booking.setUuid(UUID.randomUUID());
        storage.save(booking);
    }

    /**
     * Проверка дня бронирования
     */
    private boolean isDayBooked(Booking booking) {
        return storage.getData().values().stream().anyMatch(getCombinedPredicate(booking));
    }

    /**
     * Получение предиката бронирования по дню месяца
     */
    private Predicate<Booking> getCombinedPredicate(Booking booking) {
        List<Predicate<Booking>> predicates = new ArrayList<>();
        predicates.add(e -> e.getMonthNumber() == booking.getMonthNumber());
        predicates.add(e -> e.getDayNumber() == booking.getDayNumber());
        return predicates.stream().reduce(Predicate::and).orElse(e -> false);
    }
}
