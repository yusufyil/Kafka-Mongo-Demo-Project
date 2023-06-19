package com.example.quoteconsumer;

import com.example.quoteconsumer.service.KafkaListenerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class QuoteConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoteConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaListenerService kafkaListenerService) {
        return args -> {
            System.out.println("Quote Consumer Application Started");
            //kafkaListenerService.listen("Hello World");
        };
    }
}
