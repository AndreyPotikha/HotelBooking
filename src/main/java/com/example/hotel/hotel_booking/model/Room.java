package com.example.hotel.hotel_booking.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int number;
    private String category;
    private double price;
    private String arrivalDate;
    private String departureDate;
    private String breakfast;
    @OneToOne
    private User user;
}
