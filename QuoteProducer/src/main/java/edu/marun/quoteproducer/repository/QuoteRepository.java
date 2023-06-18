package edu.marun.quoteproducer.repository;

import edu.marun.quoteproducer.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends MongoRepository<Quote, String> {

}
