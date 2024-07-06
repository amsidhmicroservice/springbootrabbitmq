package com.amsidh.mvc.controller;

import com.amsidh.mvc.model.PersonMessage;
import com.amsidh.mvc.service.RabbitMQProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/send")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    @GetMapping
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message published");
    }

    @PostMapping
    public ResponseEntity<String> sendPerson(@RequestBody PersonMessage personMessage) throws JsonProcessingException {
        rabbitMQProducer.sendPerson(personMessage);
        return ResponseEntity.ok("Person Message published");
    }
}
