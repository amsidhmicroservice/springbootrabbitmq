package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.model.PersonMessage;
import com.amsidh.mvc.service.RabbitMQProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class RabbitMQProducerImpl implements RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;


    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    @Value("${spring.rabbit.json-routing-key}")
    private String jsonRoutingKey;

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        log.info("Message Published ->{}", message);
    }

    @Override
    public void sendPerson(PersonMessage personMessage) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, personMessage);
        log.info("Person Published ->{}", new ObjectMapper().writeValueAsString(personMessage));
    }
}
