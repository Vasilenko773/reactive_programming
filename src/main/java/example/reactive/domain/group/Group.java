package example.reactive.domain.group;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.Random;


@Data
@Table(name = "groups")
@NoArgsConstructor
public class Group implements Persistable<Integer> {

    @Id
    private Integer id;
    private String number;

    public Group(Integer id) {
        this.id = id;
    }

    public Group(Integer id, String number) {
        this.id = id;
        this.number = number;
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
