package com.project.kafka.cil.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.project.kafka.cil.entity.Entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,Entity> kafkaTemplate;
    public void sendMessage(Entity entity) {
    	
    	Message<Entity> message = MessageBuilder
	                .withPayload(entity)
	                .setHeader(KafkaHeaders.TOPIC, "test-topic")
	                .build();

        LOGGER.info("ENTITY PRODUCED INTO TOPIC \n"+entity);
        kafkaTemplate.send("test_topic",message.getPayload());
    }
}

