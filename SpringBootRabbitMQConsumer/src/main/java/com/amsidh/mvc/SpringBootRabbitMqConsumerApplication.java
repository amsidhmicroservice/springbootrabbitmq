package com.amsidh.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootRabbitMqConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqConsumerApplication.class, args);
    }

    @RabbitListener(queues = {"${spring.rabbitmq.template.default-receive-queue}"})
    @Override
    public void run(String... args) {
        if (args.length > 0) {
            log.info("Message Received ->{}", args[0]);
        }
    }
}
