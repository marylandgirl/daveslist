package com.example.daveslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/home")
    public String home(){
        return "homepage";
    }
    @RequestMapping("/")
    public String showRooms(Model model){
        model.addAttribute("list",roomRepository.findAllByPrivated(false));
        return "listings";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping("/unlisted")
    public String failure(){return "failure";}

    @GetMapping("/register")
    public String registerUser(Model model)
    {
        model.addAttribute("newUser",new User());
        return "registration";
    }

    @PostMapping("/register")
    public String addNewUser(@Valid @ModelAttribute("NewUser") User newUser, BindingResult result, Model model)
    {

        if(result.hasErrors())
        {
            System.out.println(result.toString());
            return "registration";
        }
        else{
            //Create a new ordinary user
            model.addAttribute(newUser.getUsername()+" created");
            Role r = roleRepository.findByRole("USER");
            userRepository.save(newUser);
            newUser.addRole(r);
            userRepository.save(newUser);
            return "redirect:/private";
        }
    }

    @RequestMapping("/list")
    public String roomList(Model model){
        model.addAttribute("list",roomRepository.findAll());
        return "listings";
    }
    @RequestMapping("/private")
    public String showPrivate(Model model){
        model.addAttribute("list",roomRepository.findAll());
        return "listings";
    }
    @RequestMapping("/public")
    public String showpublic(Model model){
        model.addAttribute("list",roomRepository.findAllByPrivated(false));
        return "listings";
    }

}
