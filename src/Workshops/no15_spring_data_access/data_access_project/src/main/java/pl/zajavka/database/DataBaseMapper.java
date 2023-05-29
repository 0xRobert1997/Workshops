package pl.zajavka.database;

import org.springframework.stereotype.Component;
import pl.zajavka.domain.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Component
public class DataBaseMapper {

    private static final DateTimeFormatter DATA_BASE_FORMAT
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

    public Map<String, ?> map(Product product) {
        return Map.of(
                "product_code", product.getProductCode(),
                "product_name", product.getProductName(),
                "product_price", product.getProductPrice(),
                "adults_only", product.getAdultsOnly(),
                "description", product.getDescription(),
                "producer_id", product.getProducer().getId()
        );
    }

    public Map<String, ?> map(Opinion opinion) {
        return Map.of(
                "customer_id", opinion.getCustomer().getId(),
                "product_id", opinion.getProduct().getId(),
                "stars", opinion.getStars(),
                "comment", opinion.getComment(),
                "date_time", opinion.getDateTime().format(DATA_BASE_FORMAT)

        );
    }

    public Map<String, ?> map(Purchase purchase) {
        return Map.of(
                "customer_id", purchase.getCustomer().getId(),
                "product_id", purchase.getProduct().getId(),
                "quantity", purchase.getQuantity(),
                "date_time", purchase.getDateTime().format(DATA_BASE_FORMAT)
        );
    }

    public Customer mapCustomer(ResultSet resultSet, int rowNum) throws SQLException {
        return Customer.builder()
                .id(resultSet.getLong("ID"))
                .userName(resultSet.getString("user_name"))
                .email(resultSet.getString("email"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .dateOfBirth(LocalDate.parse(resultSet.getString("date_of_birth")))
                .telephoneNumber(resultSet.getString("telephone_number"))
                .build();
    }

    public Purchase mapPurchase(ResultSet resultSet, int rowNum) throws SQLException {
        return Purchase.builder()
                .id(resultSet.getLong("id"))
                .customer(Customer.builder().id(resultSet.getLong("customer_id")).build())
                .product(Product.builder().id(resultSet.getLong("product_id")).build())
                .quantity(resultSet.getInt("quantity"))
                .dateTime(OffsetDateTime.parse(resultSet.getString("date_time"), DATA_BASE_FORMAT)
                        .withOffsetSameInstant(ZoneOffset.UTC))
                .build();
    }

    public Opinion mapOpinion(ResultSet resultSet, int rowNum) throws SQLException {
        return Opinion.builder()
                .id(resultSet.getLong("id"))
                .customer(Customer.builder().id(resultSet.getLong("customer_id")).build())
                .product(Product.builder().id(resultSet.getLong("product_id")).build())
                .stars(resultSet.getInt("stars"))
                .comment(resultSet.getString("comment"))
                .dateTime(OffsetDateTime.parse(resultSet.getString("date_time"), DATA_BASE_FORMAT)
                        .withOffsetSameInstant(ZoneOffset.UTC))
                .build();
    }

    public Producer mapProducer(ResultSet resultSet, int rowNum) throws SQLException {
        return Producer.builder()
                .id(resultSet.getLong("id"))
                .producerName(resultSet.getString("producer_name"))
                .address(resultSet.getString("address"))
                .build();
    }

    public Product mapProduct(ResultSet resultSet, int rowNum) throws SQLException {
        return Product.builder()
                .id(resultSet.getLong("id"))
                .productName(resultSet.getString("product_name"))
                .productCode(resultSet.getString("product_code"))
                .productPrice(resultSet.getBigDecimal("product_price"))
                .producer(Producer.builder().id(resultSet.getLong("producer_id")).build())
                .description(resultSet.getString("description"))
                .adultsOnly(resultSet.getBoolean("adults_only"))
                .build();
    }
}
