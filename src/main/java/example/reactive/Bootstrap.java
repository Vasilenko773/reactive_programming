package example.reactive;

import example.reactive.domain.student.Student;
import example.reactive.domain.student.StudentReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final StudentReactiveRepository studentReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("#####");
        studentReactiveRepository.save(new Student("Boris"));
        studentReactiveRepository.save(new Student("Moris"));
        System.out.println("student count:" + studentReactiveRepository.count().block());

    }
}
