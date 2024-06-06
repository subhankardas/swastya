package com.codespark.auth.configs;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
public class KafkaConfig {

    @Value("${events.topics}")
    private List<String> topics;

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @Bean
    public List<NewTopic> createKafkaTopics(KafkaAdmin admin) {
        return topics.stream().map(topicName -> {
            return TopicBuilder.name(topicName).build();
        }).collect(Collectors.toList());
    }

}
