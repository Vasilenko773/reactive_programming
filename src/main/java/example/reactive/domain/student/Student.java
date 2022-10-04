package example.reactive.domain.student;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;


@Data
@Table(name = "students")
@NoArgsConstructor
public class Student implements Persistable<Integer> {

    @Id
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean isNew() {
        boolean result = Objects.isNull(id);
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        this.id = result ? randomWithNextInt : this.id;
        return result;
    }
}
