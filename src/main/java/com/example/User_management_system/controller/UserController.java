package com.example.User_management_system.controller;

import com.example.User_management_system.entity.User;
import com.example.User_management_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    public String  createUser(User user){
       userService.createUser(user);
       return "usercreated !";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id ){
        userService.getUser(id);
        return "User data ";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/public/hello")
    @ResponseBody
    public String publicHello() {
        return "This is a public endpoint.";
    }

    @GetMapping("/continue")
    public String continuePage() {
        return "You have successfully reached the /continue endpoint!";
    }
}
