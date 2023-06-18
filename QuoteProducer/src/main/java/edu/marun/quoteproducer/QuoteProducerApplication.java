package edu.marun.quoteproducer;

import edu.marun.quoteproducer.model.Quote;
import edu.marun.quoteproducer.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuoteProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoteProducerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(QuoteRepository quoteRepository) {
        return args -> {
            Quote quote = Quote.builder()
                    .quote("The best way to predict the future is to create it.")
                    .build();
            Quote saved = quoteRepository.save(quote);
            System.out.println(quoteRepository.findById(saved.getId()));
        };
    }

}
