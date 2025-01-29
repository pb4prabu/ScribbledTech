package com.scribbledtech.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "scribbled-tech-topic", groupId = "scribbled-tech-consumer-group")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println(String.format("Consumed message: key=%s, value=%s, partition=%d, offset=%d",
                record.key(), record.value(), record.partition(), record.offset()));
    }
}
