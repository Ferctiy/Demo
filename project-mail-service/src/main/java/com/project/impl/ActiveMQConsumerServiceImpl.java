package com.project.impl;

import com.alibaba.fastjson.JSON;
import com.project.daomain.entities.MailEntry;
import com.project.daomain.model.MailModel;
import com.project.service.ActiveMQConsumerService;
import com.project.service.MailService;
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
        MailModel model = JSON.parseObject(message,MailModel.class);
        this.mailService.sendSimpleMail(model);
        System.out.println("message = " + message);
    }
}
