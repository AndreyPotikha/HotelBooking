package com.example.hotel.hotel_booking.service;

import com.example.hotel.hotel_booking.repository.RoomRepository;
import com.example.hotel.hotel_booking.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    private String findRoomByNumbe;

    public void save(Room room) {
        roomRepository.save(room);
    }

    public List<Room> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(roomRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public Room findRoomByNumber(int number) {
        return roomRepository.findRoomByNumber(number);
    }

    public List<Room> findRoomByCategory(String category) {
        return roomRepository.findRoomByCategory(category);
    }
}
