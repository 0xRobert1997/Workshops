package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QueryByExampleService {
    private final CustomerDatabaseRepository customerDatabaseRepository;

    public void queryByExample() {
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());


        CustomerEntity customerExample = CustomerEntity.builder()
                .name("G")
                .email("com")
                .build();

        Example<CustomerEntity> example = Example.of(customerExample, caseInsensitiveExampleMatcher);
        List<CustomerEntity> all = customerDatabaseRepository.findAll(example);
        System.out.println("###FOUND: " + all);
    }
}
