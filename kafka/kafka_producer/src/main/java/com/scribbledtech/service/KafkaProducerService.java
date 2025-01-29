package com.scribbledtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaProducerService {

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "scribbled-tech-topic"; // Topic name

    @Transactional
    public void sendMessage(String key, String message) {

        kafkaTemplate.executeInTransaction(operations -> {
            operations.send(TOPIC, key, message);
            System.out.println(String.format("Produced message: key=%s, value=%s", key, message));
            return null;
        });
    }
}