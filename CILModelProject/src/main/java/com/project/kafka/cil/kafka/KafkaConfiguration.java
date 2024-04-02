package com.project.kafka.cil.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

@Component
public class KafkaConfiguration {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public NewTopic kafkaTopic() {
        return TopicBuilder.name(topicName)
                .build();
    }
}
