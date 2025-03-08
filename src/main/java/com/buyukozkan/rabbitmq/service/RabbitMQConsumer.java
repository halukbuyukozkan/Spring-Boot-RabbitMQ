package com.buyukozkan.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.buyukozkan.rabbitmq.model.Employee;
@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "${buyukozkan.rabbitmq.queue}")
    public void receivedMessage(Employee employee) {
        System.out.println("RabbitMQ'dan gelen mesaj: " + employee);
    }
}
