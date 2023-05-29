package pl.zajavka.integration;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.zajavka.Configuration.ApplicationConfiguration;
import pl.zajavka.business.*;
import pl.zajavka.domain.Customer;
import pl.zajavka.domain.Producer;
import pl.zajavka.domain.Product;
import pl.zajavka.domain.StoreFixtures;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShoppingCartServiceTest {

    private ShoppingCartService shoppingCartService;
    private CustomerService customerService;
    private PurchaseService purchaseService;
    private ProductService productService;
    private ProducerService producerService;

    @BeforeEach
    public void setUp() {
        Assertions.assertNotNull(shoppingCartService);
        Assertions.assertNotNull(customerService);
        Assertions.assertNotNull(productService);
        Assertions.assertNotNull(producerService);
        Assertions.assertNotNull(purchaseService);
        customerService.removeAll();
        producerService.removeAll();

    }

    @Test
    @DisplayName("Polecenie 9")
    void thatProductCanBeBoughtByCustomer() {
        //given
        final Customer customer = customerService.create(StoreFixtures.someCustomer());
        final Producer producer = producerService.create(StoreFixtures.someProducer());
        final Product product1 = productService.create(StoreFixtures.someProduct1(producer));
        final Product product2 = productService.create(StoreFixtures.someProduct2(producer));
        purchaseService.findAll(customer.getEmail(), product1.getProductCode());
        final var before = purchaseService.findAll(customer.getEmail(), product1.getProductCode());

        //when
        shoppingCartService.makeAPurchase(customer.getEmail(), product1.getProductCode(), 10);

        //then
        final var after = purchaseService.findAll(customer.getEmail(), product1.getProductCode());
        Assertions.assertEquals(before.size() + 1, after.size());
    }
}
