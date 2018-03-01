package com.example.hotel.hotel_booking.controller;

import com.example.hotel.hotel_booking.model.User;
import com.example.hotel.hotel_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("users", service.getAll());
        return "main";
    }

    @RequestMapping("/editor")
    public String editorPage(Model model) {
        model.addAttribute("user", new  User());
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute User user) {
        service.save(user);
        return "redirect:../";
    }

}
