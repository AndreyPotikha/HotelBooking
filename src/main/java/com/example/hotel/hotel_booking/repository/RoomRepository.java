package com.example.hotel.hotel_booking.repository;

import com.example.hotel.hotel_booking.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    public Room findRoomByNumber(int number);

    public List<Room> findRoomByCategory(String category);
}
