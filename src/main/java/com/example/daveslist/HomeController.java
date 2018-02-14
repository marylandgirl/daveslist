package com.example.daveslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class HomeController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/")
    public String showRooms(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
