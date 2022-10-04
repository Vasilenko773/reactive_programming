package example.reactive.domain.student;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@RequiredArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    private String id;
    private final String name;
}
