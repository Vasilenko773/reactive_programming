package example.reactive.domain.group;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface GroupReactiveRepository extends ReactiveCrudRepository<Group, String> {

    Mono<Group> findById(String id);

    Flux<Group> findAll();
}
