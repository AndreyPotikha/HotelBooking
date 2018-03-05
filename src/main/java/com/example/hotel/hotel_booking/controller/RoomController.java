package com.example.hotel.hotel_booking.controller;

import com.example.hotel.hotel_booking.model.Room;
import com.example.hotel.hotel_booking.model.User;
import com.example.hotel.hotel_booking.service.RoomService;
import com.example.hotel.hotel_booking.service.UserService;
import com.example.hotel.hotel_booking.util.CountDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("message", "\n" + "Made by Potikha Andrey");
        return "main";
    }

    @RequestMapping("/editor")
    public String bookingPage(Model model) {
        model.addAttribute("rooms", roomService.getAll());
        model.addAttribute("choice_room", new Room());
        return "editor";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String categoryFilter(Model model, @ModelAttribute Room room) {
        System.out.println(room.getCategory());
        model.addAttribute("room_by_category", roomService.findRoomByCategory(room.getCategory()));
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.GET)
    public String bookingRoom(@ModelAttribute Room room, Model model) {
        Room roomByNumber = roomService.findRoomByNumber(room.getNumber());
        roomByNumber.setArrivalDate(room.getArrivalDate());
        roomByNumber.setDepartureDate(room.getDepartureDate());
        roomByNumber.setBreakfast(room.getBreakfast());

        User user = userService.findUser();
        user.setRoom(roomByNumber);
        user.setArrivalDate(room.getArrivalDate());
        user.setDepartureDate(room.getDepartureDate());
        userService.save(user);

        roomByNumber.setUser(user);
        roomService.save(roomByNumber);

        CountDate countDate = new CountDate();
        int days = countDate.countDate(roomByNumber.getArrivalDate(), roomByNumber.getDepartureDate());

        if (roomByNumber.getBreakfast() == null) {
            model.addAttribute("new_booking", roomByNumber.getPrice());
        } else if (roomByNumber.getBreakfast().equals("true")) {
            int price = (int) (days * 20 + roomByNumber.getPrice());
            model.addAttribute("new_booking_price", price);
        }

        model.addAttribute("new_booking_number_room", roomByNumber.getNumber());
        model.addAttribute("new_booking_category_room", roomByNumber.getCategory());
        model.addAttribute("new_booking_breakfast", roomByNumber.getBreakfast());

        return "new_booking";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

}

