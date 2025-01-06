package com.example.User_management_system.service;

import com.example.User_management_system.entity.User;
import com.example.User_management_system.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testCreateUser() {

       User user = new User();

       when(userRepository.save(user)).thenReturn(user);

        User createuser = userService.createUser(user);

        assertEquals("Vikram",createuser.getName());

    }
}

