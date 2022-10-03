package example.reactive.domain.group;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Group {

    @Id
    private String id;
    private String number;
}
