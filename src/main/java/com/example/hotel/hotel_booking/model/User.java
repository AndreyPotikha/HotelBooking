package com.example.hotel.hotel_booking.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String numberOfPhone;
    private String password;
    private String arrivalDate;
    private String departureDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "room_number")
    private Room room;



}
