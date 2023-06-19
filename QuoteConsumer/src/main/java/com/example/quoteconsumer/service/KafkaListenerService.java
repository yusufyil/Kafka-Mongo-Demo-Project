package com.example.quoteconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @KafkaListener(topics = "quotes", groupId = "foo")
    public void listen(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
