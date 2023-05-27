package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.*;

@Service
@AllArgsConstructor
public class RandomDataService2 {
    private final RandomDataPreparationService randomDataPreparationService;
    private final CustomerRepository customerRepository;
    private final OpinionRepository opinionRepository;
    private final ProducerRepository producerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    @Transactional
    public void create() {
        Customer customer = customerRepository.create(randomDataPreparationService.createCustomer());
        Producer producer = producerRepository.create(randomDataPreparationService.createProducer());
        Product product = productRepository.create(randomDataPreparationService.createProduct(producer));
        Opinion opinion = opinionRepository.create(randomDataPreparationService.createOpinion(customer, product));
        Purchase purchase = purchaseRepository.create(randomDataPreparationService.createPurchase(customer, product));
    }
}
