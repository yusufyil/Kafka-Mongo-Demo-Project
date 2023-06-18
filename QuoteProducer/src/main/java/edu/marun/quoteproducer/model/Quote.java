package edu.marun.quoteproducer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Document(collection = "quotes")
public class Quote {

    @Id
    private String id;
    private String quote;
}
