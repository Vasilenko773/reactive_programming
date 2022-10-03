package example.reactive.domain.student;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentReactiveRepository extends ReactiveMongoRepository<Student, String> {

    Mono<Student> findById(int id);

    Flux<Student> findAll();
}
