package com.javaacademy.wedding_host.storage;

import com.javaacademy.wedding_host.model.Booking;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class BookingStorage {
    private final Map<UUID, Booking> data = new HashMap<>();

    /**
     * Возвращает все данные из хранилища
     */
    public Map<UUID, Booking> getData() {
        return new HashMap<>(data);
    }

    /**
     * Сохранение в хранилище новой записи бронирования, проверка по uuid
     */
    public void save(Booking booking) {
        if (data.containsKey(booking.getUuid())) {
            throw new RuntimeException("Уже есть такая запись с таким uuid: %s".formatted(booking.getUuid()));
        }
        data.put(booking.getUuid(), booking);
    }
}
