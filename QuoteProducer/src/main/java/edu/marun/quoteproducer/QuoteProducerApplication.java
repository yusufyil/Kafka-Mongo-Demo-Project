package edu.marun.quoteproducer;

import edu.marun.quoteproducer.model.Quote;
import edu.marun.quoteproducer.repository.QuoteRepository;
import edu.marun.quoteproducer.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Random;

@SpringBootApplication
public class QuoteProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoteProducerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(QuoteRepository quoteRepository, KafkaTemplate<String, String> kafkaTemplate, QuoteService quoteService) {
        return args -> {
            while (true){
                Quote quote = Quote.builder()
                        .quote(quoteService.getQuote())
                        .build();
                quoteRepository.save(quote);
                kafkaTemplate.send("quotes", quoteService.getQuote());
                Thread.sleep(10_000);
            }
        };
    }
}
