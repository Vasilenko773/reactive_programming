package example.reactive.domain.student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Student {

    @Id
    private String id;
    private String name;
}
