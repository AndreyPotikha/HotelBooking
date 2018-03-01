package com.example.hotel.hotel_booking.service;

import com.example.hotel.hotel_booking.dao.UserRepository;
import com.example.hotel.hotel_booking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

        @Autowired
        private UserRepository repository;

        public void save(User user) {
            repository.save(user);
        }

        public List<User> getAll() {
            return StreamSupport
                    .stream(
                            Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                            false)
                    .collect(Collectors.toList());
        }
    }

