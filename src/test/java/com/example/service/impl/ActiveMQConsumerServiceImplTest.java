package com.example.service.impl;

import com.example.service.ActiveMQConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActiveMQConsumerServiceImplTest {

    @Autowired
    protected ActiveMQConsumerService activeMQConsumerService;

    @Test
    public void receiveMessage() {
        this.activeMQConsumerService.receiveMessage(" ");
        System.out.println(" Receive Message ");
    }
}