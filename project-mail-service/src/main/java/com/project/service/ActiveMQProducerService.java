package com.project.service;


import com.project.daomain.entities.MailEntry;
import com.project.daomain.model.MailModel;

public interface ActiveMQProducerService {

    /**
     *  Topic
     *  Publish Subscription Model
     *  @param model MailModel
     */
    void sendTopicMessage(MailModel model);


    /**
     * Queue
     * Queue Model
     *
     * @param model MailModel
     */
    void  sendQueueMessage(MailModel model);
}
