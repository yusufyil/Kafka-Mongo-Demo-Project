package edu.marun.quoteproducer.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

        public String getQuote() {
            Faker faker = new Faker();
            return faker.hitchhikersGuideToTheGalaxy().quote();
        }
}
