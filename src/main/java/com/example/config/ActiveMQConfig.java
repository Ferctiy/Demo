package com.example.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class ActiveMQConfig {

    @Value("${spring.activemq.topic-name}")
    private String topicName;

    @Value("${spring.activemq.queue-name}")
    private String queueName;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(this.queueName);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTempTopic(this.topicName);
    }
}
