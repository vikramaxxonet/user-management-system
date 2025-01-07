package com.example.User_management_system.service;


import com.example.User_management_system.entity.User;
import com.example.User_management_system.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RabbitTemplate rabbitTemplate;

    public UserService(UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    //method for create user
    public User createUser(User user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }

        User savedUser = userRepository.save(user);


        rabbitTemplate.convertAndSend("userQueue", "UserCreated: " + savedUser.getName());

        return savedUser;
    }

    //method for getuser by id
    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    //method for get allusers
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
