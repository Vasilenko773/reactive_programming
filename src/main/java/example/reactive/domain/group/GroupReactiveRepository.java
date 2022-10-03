package example.reactive.domain.group;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface GroupReactiveRepository extends ReactiveMongoRepository<Group, String> {

    Mono<Group> findById(int id);

    Flux<Group> findAll();
}
