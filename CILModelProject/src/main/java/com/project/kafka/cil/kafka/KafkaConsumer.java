package com.project.kafka.cil.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.project.kafka.cil.entity.Entity;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "group-id")
    public void consume(Entity entity){
        LOGGER.info("Entity CONSUMED FROM TOPIC \n"+entity);
    }
}