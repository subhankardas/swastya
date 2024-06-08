package com.codespark.auth.service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.codespark.auth.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaEventServiceImpl implements EventService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Async
    @Override
    public <K, V> void publish(String topic, K key, V message) {
        kafkaTemplate.send(topic, key, message).whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Failed to publish event: {} to topic: {}", message, topic, ex);
                throw new RuntimeException(ex);
            }
            log.debug("Event with key: {} sent to topic: {}", key, topic);
        });
    }

}
