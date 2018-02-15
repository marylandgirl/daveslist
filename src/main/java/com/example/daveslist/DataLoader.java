package com.example.daveslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data ...");

        Room room = new Room("123 Park Ave", "New York", "New York", "2500.00",
                "Efficiency", "No Drugs", true, "Basic", true, false);
    }

}
