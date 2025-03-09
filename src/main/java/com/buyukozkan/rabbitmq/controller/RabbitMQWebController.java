package com.buyukozkan.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyukozkan.rabbitmq.model.Employee;
import com.buyukozkan.rabbitmq.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/buyukozkan-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @RequestMapping(value = "/producer")
    public String producer(@RequestParam("name") String name, @RequestParam("id") String id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        rabbitMQSender.send(employee);

        return "Message sent to the RabbitMQ Successfully";
    }
}
