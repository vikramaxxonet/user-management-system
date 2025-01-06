package com.example.User_management_system.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "userQueue")
    public void rabbitMQlisteen(String message ){

        System.out.println("Message receives:" + message);

    }
}
