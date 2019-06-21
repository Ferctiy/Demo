package com.example.service;


import com.example.entry.MailEntry;

public interface ActiveMQProducerService {

    /**
     *  Topic
     *  Publish Subscription Model
     *  @param mailEntry MMailEntry
     */
    void sendTopicMessage(MailEntry mailEntry);


    /**
     * Queue
     * Queue Model
     *
     * @param mailEntry MailEntry
     */
    void  sendQueueMessage(MailEntry mailEntry);
}
