package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NamedQueryService {

    private final CustomerDatabaseRepository customerDatabaseRepository;

    public void call() {
        List<CustomerEntity> allCustomers = customerDatabaseRepository.findAllCustomersNQ();

        customerDatabaseRepository.findCustomerByEmailNQ("mmattiessen3@theatlantic.com");
    }
}
