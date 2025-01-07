package com.example.User_management_system.controller;

import com.example.User_management_system.entity.User;
import com.example.User_management_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {

        if (user.getName() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Name and Email cannot be null");
        }

        userService.createUser(user);
        return "usercreated!";
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
