package example.reactive.domain.group;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Group {

    @Id
    private String id;
    private String number;
}
