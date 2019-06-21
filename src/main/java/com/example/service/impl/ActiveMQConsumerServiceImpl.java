package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.entry.MailEntry;
import com.example.service.ActiveMQConsumerService;
import com.example.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * ActiveMQ Consumer
 */
@Service
@Slf4j
public class ActiveMQConsumerServiceImpl implements ActiveMQConsumerService {

    @Autowired
    private MailService mailService;

    /**
     * Receive Message
     *
     * @param message
     */
    @JmsListener(destination = "${spring.activemq.topic-name}")
    //@JmsListener(destination =  "${spring.activemq.queue-name}")
    public void receiveMessage(String message) {
        MailEntry mailEntry = JSON.parseObject(message,MailEntry.class);
        this.mailService.sendSimpleMail(mailEntry);
        System.out.println("message = " + message);

    }
}
