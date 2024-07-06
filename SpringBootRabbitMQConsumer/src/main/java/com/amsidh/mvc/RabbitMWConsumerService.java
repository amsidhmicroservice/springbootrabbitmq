package com.amsidh.mvc;

import com.amsidh.mvc.model.PersonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMWConsumerService {

    @RabbitListener(queues = {"${spring.rabbitmq.template.default-receive-queue}"})
    public void messageListener(String message) {
        log.info("Message Received ->{}", message);
    }

    @RabbitListener(queues = {"${spring.rabbitmq.json-queue}"})
    public void personListener(PersonMessage personMessage) throws JsonProcessingException {
        log.info("Person Received ->{}", new ObjectMapper().writeValueAsString(personMessage));
    }
}
