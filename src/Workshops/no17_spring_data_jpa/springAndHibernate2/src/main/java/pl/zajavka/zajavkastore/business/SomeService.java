package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories.*;

@Service
@AllArgsConstructor
public class SomeService {

    private final CustomerDatabaseRepository customerDatabaseRepository;
    private final OpinionDatabaseRepository opinionDatabaseRepository;
    private final ProducerDatabaseRepository producerDatabaseRepository;
    private final ProductDatabaseRepository productDatabaseRepository;
    private final PurchaseDatabaseRepository purchaseDatabaseRepository;

    public void call() {

    }
}
