package com.example.daveslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data ...");
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Room room = new Room("123 Park Ave", "New York", "New York", "2500.00",
                "Efficiency", "No Drugs", true, "Basic", true, false,false);
        roomRepository.save(room);

        room = new Room("123 Park Ave", "Baltimore", "Maryland", "2500.00",
                "Efficiency", "No Drugs", true, "Premium", true, false,false);
        roomRepository.save(room);

        room = new Room("123 Park Ave", "Nome", "Alaska", "2500.00",
                "Efficiency", "Drugs Welcome", false, "None", false, false,true);
        roomRepository.save(room);

        room = new Room("123 Park Ave", "Albany", "New York", "2500.00",
                "Efficiency", "No Drugs", false, "Basic", true, false,false);
        roomRepository.save(room);

        room = new Room("123 Park Ave", "Atlanta", "Georgia", "2500.00",
                "Efficiency", "No Drugs", true, "Premium", true, false,true);
        roomRepository.save(room);
    }

}
