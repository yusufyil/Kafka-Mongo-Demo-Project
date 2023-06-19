package edu.marun.quoteproducer;

import edu.marun.quoteproducer.model.Quote;
import edu.marun.quoteproducer.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class QuoteProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoteProducerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(QuoteRepository quoteRepository, KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            Quote quote = Quote.builder()
                    .quote("The best way to predict the future is to create it.")
                    .build();
            //Quote saved = quoteRepository.save(quote);
            //System.out.println(quoteRepository.findById(saved.getId()));
            kafkaTemplate.send("quotes", "Hello Kafka");
            Thread.sleep(4000);
            System.out.println("Message sent");
        };
    }

}
