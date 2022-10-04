package example.reactive.domain.student;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface StudentReactiveRepository extends ReactiveCrudRepository<Student, Integer> {
    Mono<Student> findById(Integer id);
}
