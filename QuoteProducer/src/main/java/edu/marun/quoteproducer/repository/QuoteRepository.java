package edu.marun.quoteproducer.repository;

import edu.marun.quoteproducer.model.Quote;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends MongoRepository<Quote, String> {

    default Quote findLastAddedElement() {
        PageRequest pageRequest = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "createdAt"));
        return findAll(pageRequest).getContent().get(0);
    }

}
