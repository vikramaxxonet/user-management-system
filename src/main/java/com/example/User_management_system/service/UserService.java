package com.example.User_management_system.service;


import com.example.User_management_system.entity.User;
import com.example.User_management_system.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private RabbitTemplate rabbitTemplate;

    //method for create user
    public User createUser(User user){

        User saveuser = userRepository.save(user);
        rabbitTemplate.convertAndSend(
                "userqueue","Usercreated:",user.getName());
        return saveuser;
    }

    //method for getuser by id
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    //method for get allusers
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
