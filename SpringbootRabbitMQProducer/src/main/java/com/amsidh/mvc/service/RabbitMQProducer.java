package com.amsidh.mvc.service;

import com.amsidh.mvc.model.PersonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RabbitMQProducer {
    public void sendMessage(String message);
    void sendPerson(PersonMessage personMessage) throws JsonProcessingException;
}
