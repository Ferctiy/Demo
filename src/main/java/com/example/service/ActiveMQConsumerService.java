package com.example.service;

public interface ActiveMQConsumerService {

    /**
     * Receive Message
     * @param message Receive Message
     */
    void receiveMessage(String message);
}
