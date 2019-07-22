package com.project.impl;

import com.alibaba.fastjson.JSON;
import com.project.service.ActiveMQProducerService;
import com.project.daomain.model.MailModel;
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
     *
     * Publish Subscription Model
     *
     * @param model MailModel
     */
    @Override
    public void sendTopicMessage(MailModel model) {
        System.out.println ("model = " + model);
        try {
            this.jmsMessagingTemplate.convertAndSend(this.topic.getTopicName(), JSON.toJSONString(model));
        } catch (Exception e) {
            log.error(String.format(" Topic Exception Message：%s", e));
        }
    }

    /**
     * Queue
     * Queue Model
     *
     * @param model MailModel
     */
    @Override
    public void sendQueueMessage(MailModel model) {
        try {
            this.jmsMessagingTemplate.convertAndSend(this.queue.getQueueName(), JSON.toJSONString(model));
        } catch (Exception e) {
            log.error(String.format(" Queue Exception Message：%s", e));
        }
    }
}
