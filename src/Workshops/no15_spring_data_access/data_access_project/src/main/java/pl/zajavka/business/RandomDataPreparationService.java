package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class RandomDataPreparationService {

    public Customer createCustomer() {
        return Customer.builder()
                .userName(generateRandomString())
                .email(generateRandomEmail())
                .name(generateRandomString())
                .surname(generateRandomString())
                .dateOfBirth(generateRandomDate())
                .telephoneNumber(generateRandomPhoneNumber())
                .build();
    }

    public Opinion createOpinion(Customer customer, Product product) {
        return Opinion.builder()
                .customer(customer)
                .product(product)
                .stars(new Random().nextInt(1,5))
                .comment(generateRandomString())
                .dateTime(generateRandomOffsetDateTime())
                .build();
    }

    public Producer createProducer() {
        return Producer.builder()
                .producerName(generateRandomString())
                .address(generateRandomAddress())
                .build();
    }

    public Product createProduct(Producer producer) {
        return Product.builder()
                .productCode(generateRandomString())
                .productName(generateRandomString())
                .productPrice(generateRandomBD(2))
                .adultsOnly(generateRandomBoolean())
                .description(generateRandomString())
                .producer(producer)
                .build();
    }

    public Purchase createPurchase(Customer customer, Product product) {
        return Purchase.builder()
                .customer(customer)
                .product(product)
                .quantity(generateRandomInteger(1))
                .dateTime(generateRandomOffsetDateTime())
                .build();
    }

    private String generateRandomString() {
        return new Random().ints(5, 0, 62)
                .mapToObj("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private String generateRandomAddress() {
        return new Random().ints(5, 0, 62)
                .mapToObj("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"::charAt)
                .map(Object::toString)
                .collect(Collectors.joining()) + " Street";
    }

    private String generateRandomEmail() {
        return new Random().ints(5, 0, 62)
                .mapToObj("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"::charAt)
                .map(Object::toString)
                .collect(Collectors.joining()) + "@random.com";
    }

    private Integer generateRandomInteger(int size) {
        String collect = new Random().ints(size, 1, 9)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining());
        return Integer.valueOf(collect);
    }
    private BigDecimal generateRandomBD(int size) {
        String collect = new Random().ints(size, 1, 9)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining());
        return new BigDecimal(collect);
    }

    private String generateRandomPhoneNumber() {
        String collect = new Random().ints(11, 0, 9)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining());

        char[] chars = collect.toCharArray();
        chars[2] = '-';
        chars[6] = '-';
        return String.valueOf(chars);
    }

    private Boolean generateRandomBoolean() {
        return new Random().nextBoolean();
    }

    private OffsetDateTime generateRandomOffsetDateTime() {
        OffsetDateTime startDate = OffsetDateTime.of(2010, 1, 1, 1,1,5,0, ZoneOffset.ofHours(1));
        int daysToAdd = new Random().nextInt(420);
        return startDate.plus(daysToAdd, ChronoUnit.DAYS);
    }

    private LocalDate generateRandomDate() {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        int daysToAdd = new Random().nextInt(420);
        return startDate.plus(daysToAdd, ChronoUnit.DAYS);
    }
}
