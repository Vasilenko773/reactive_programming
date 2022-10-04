package example.reactive.domain.group;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface GroupReactiveRepository extends ReactiveCrudRepository<Group, Integer> {

    Mono<Group> findById(int id);

    Flux<Group> findAll();
}
