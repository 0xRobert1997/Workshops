package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories.CustomerDatabaseRepository;

@Service
@AllArgsConstructor
public class SortingService {

    private final CustomerDatabaseRepository customerDatabaseRepository;

    public void call() {
        Sort sort = Sort.by("name").ascending()
                        .and(Sort.by("dateOfBirth").ascending());

        customerDatabaseRepository.findAll(sort)
                .forEach(customer -> System.out.println("###CUSTOMER: " + customer));
    }
}
