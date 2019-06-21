package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.entry.MailEntry;
import com.example.service.ActiveMQProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * ActiveMQProducer
 */
@Service
@Slf4j
public class ActiveMQProducerServiceImpl implements ActiveMQProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    @Autowired
    private Queue queue;

    /**
     * Topic
     * Publish Subscription Model
     *
     * @param mailEntry MailEntry
     */
    @Override
    public void sendTopicMessage(MailEntry mailEntry) {
        try {
            this.jmsMessagingTemplate.convertAndSend(this.topic.getTopicName(), JSON.toJSONString(mailEntry));
        } catch (Exception e) {
            log.error(String.format(" Topic Exception Message：%s", e));
        }
    }

    /**
     * Queue
     * Queue Model
     *
     * @param mailEntry MailEntry
     */
    @Override
    public void sendQueueMessage(MailEntry mailEntry) {
        try {
            this.jmsMessagingTemplate.convertAndSend(this.queue.getQueueName(), JSON.toJSONString(mailEntry));
        } catch (Exception e) {
            log.error(String.format(" Queue Exception Message：%s", e));
        }
    }
}
