package pl.zajavka.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public class StoreFixtures {

    public static Customer someCustomer() {
        return Customer.builder()
                .userName("zajavkowicz")
                .email("zajavka.pl@gmail.com")
                .name("zajavkowicz")
                .surname("ajavkowy")
                .dateOfBirth(LocalDate.of(1990, 1, 1))
                .telephoneNumber("123456789")
                .build();
    }

    public static Producer someProducer() {
        return Producer.builder()
                .producerName("someProducer")
                .address("someAddress")
                .build();

    }

    public static Product someProduct1(Producer producer) {
        return Product.builder()
                .productName("Product1")
                .productCode("productCode1")
                .productPrice(BigDecimal.ONE)
                .producer(producer)
                .description("some description")
                .adultsOnly(true)
                .build();
    }

    public static Product someProduct2(Producer producer) {
        return Product.builder()
                .productName("Product2")
                .productCode("productCode2")
                .productPrice(BigDecimal.TEN)
                .producer(producer)
                .adultsOnly(false)
                .description("some description")
                .build();
    }

    public static Purchase somePurchase(Customer customer, Product product) {
        return Purchase.builder()
                .customer(customer)
                .product(product)
                .quantity(2)
                .dateTime(OffsetDateTime.of(LocalDate.now(), LocalTime.of(1, 1, 1), ZoneOffset.ofHours(2)))
                .build();
    }

    public static Opinion someOpinion(Customer customer, Product product) {
        return Opinion.builder()
                .customer(customer)
                .product(product)
                .stars(new Random().nextInt(1,5))
                .comment("Comment")
                .dateTime(OffsetDateTime.of(2000, 2, 1, 1, 1, 1,1, ZoneOffset.ofHours(3)))
                .build();
    }
}
