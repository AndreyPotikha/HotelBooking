package com.example.hotel.hotel_booking.repository;

import com.example.hotel.hotel_booking.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
