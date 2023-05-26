package pl.zajavka;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RandomDataService {

    private final SimpleDriverDataSource simpleDriverDataSource;

    public void fillDataBaseWithRandomData(){
        this.generateProducers(100);
        this.generateProducts(100);
        this.generateCustomers(100);
        this.generateOpinions(100);
        this.generatePurchases(300);
    }

    private void generateCustomers(int numberOfRecordsToGenerate) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = generateCustomerInsertSql();

        for (int i = 0; i < numberOfRecordsToGenerate; i++) {
            jdbcTemplate.update(
                    sql,
                    generateRandomString(),
                    generateRandomEmail(),
                    generateRandomString(),
                    generateRandomString(),
                    generateRandomDate(),
                    generateRandomPhoneNumber());
        }
    }

    private void generateProducers(int numberOfRecordsToGenerate) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = generateProducerInsertSql();
        for (int i = 0; i < numberOfRecordsToGenerate; i++) {
            jdbcTemplate.update(
                    sql,
                    generateRandomString(),
                    generateRandomAddress()
            );
        }
    }

    private void generateProducts(int numberOfRecordsToGenerate) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = generateProductsInsertSql();
        for (int i = 0; i < numberOfRecordsToGenerate; i++) {
            jdbcTemplate.update(
                    sql,
                    generateRandomInteger(5),
                    generateRandomString(),
                    generateRandomInteger(3),
                    generateRandomBoolean(),
                    generateRandomString(),
                    generateRandomInteger(2)
            );
        }
    }

    private void generatePurchases(int numberOfRecordsToGenerate) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = generatePurchaseInsertSql();
        for (int i = 0; i < numberOfRecordsToGenerate; i++) {
            jdbcTemplate.update(
                    sql,
                    generateRandomInteger(2),
                    generateRandomInteger(2),
                    generateRandomInteger(3),
                    generateRandomDateTime()
            );
        }
    }

    private void generateOpinions(int numberOfRecordsToGenerate) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = generateOpinionsInsertSql();
        for (int i = 0; i < numberOfRecordsToGenerate; i++) {
            jdbcTemplate.update(
                    sql,
                    generateRandomInteger(2),
                    generateRandomInteger(2),
                    new Random().nextInt(1,5),
                    generateRandomString(),
                    generateRandomDateTime()
            );
        }
    }

    private String generateCustomerInsertSql() {
        return "INSERT INTO CUSTOMER (USER_NAME, EMAIL, NAME, SURNAME, DATE_OF_BIRTH, TELEPHONE_NUMBER) VALUES" +
                "(?, ?, ?, ?, ?, ?)";
    }

    private String generateOpinionsInsertSql() {
        return "INSERT INTO OPINION (CUSTOMER_ID, PRODUCT_ID, STARS, COMMENT, DATE_TIME) VALUES" +
                "(?, ?, ?, ?, ?)";
    }

    private String generateProducerInsertSql() {
        return "INSERT INTO PRODUCER (PRODUCER_NAME, ADDRESS) VALUES" +
                "( ?, ?)";
    }

    private String generateProductsInsertSql() {
        return "INSERT INTO PRODUCT (PRODUCT_CODE, PRODUCT_NAME, PRODUCT_PRICE, ADULTS_ONLY, DESCRIPTION, PRODUCER_ID) VALUES" +
                "(?, ?, ?, ?, ?, ?)";

    }

    private String generatePurchaseInsertSql() {
        return "INSERT INTO PURCHASE (CUSTOMER_ID, PRODUCT_ID, QUANTITY, DATE_TIME) VALUES" +
                "(?, ?, ?, ?)";
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
                .collect(Collectors.joining()) + "@random";
    }

    private Integer generateRandomInteger(int size) {
        String collect = new Random().ints(size, 1, 9)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining());
        return Integer.valueOf(collect);
    }

    private String generateRandomPhoneNumber() {
        String collect = new Random().ints(9, 0, 9)
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

    private LocalDate generateRandomDate() {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        int daysToAdd = new Random().nextInt(420);
        return startDate.plus(daysToAdd, ChronoUnit.DAYS);
    }

    private LocalDateTime generateRandomDateTime() {
        LocalDateTime startDateTime = LocalDateTime.of(2020, 1, 1, 12, 12);
        int daysToAdd = new Random().nextInt(69420);
        return startDateTime.plus(daysToAdd, ChronoUnit.HOURS);
    }

}
