package pl.zajavka;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import pl.zajavka.domain.TableName;

@Service
@AllArgsConstructor
public class DataBaseCommandsService {

    private final SimpleDriverDataSource simpleDriverDataSource;

    public void insert(TableName table){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = generateInsertSqlTemplate(table);

        jdbcTemplate.update(sql);
    }

    public void update(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "UPDATE x SET x = ? WHERE x = ? ";
    }

    public void select(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "SELECT * FROM  ";
    }

    public void delete(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "DELETE FROM x WHERE x = ? ";
    }

    public String generateInsertSqlTemplate(TableName table) {
        return switch (table) {
            case CUSTOMER -> "INSERT INTO CUSTOMER (USER_NAME, EMAIL, NAME, SURNAME, DATE_OF_BIRTH, TELEPHONE_NUMBER) VALUES" +
                    "(?, ?, ?, ?, ?)";
            case OPINION -> "INSERT INTO OPINION (CUSTOMER_ID, PRODUCT_ID, STARS, COMMENT, DATE_TIME) VALUES" +
                    "(?, ?, ?, ?, ?)";
            case PRODUCER -> "INSERT INTO PRODUCER (PRODUCER_NAME, ADDRESS) VALUES" +
                    "( ?, ?)";
            case PRODUCT -> "INSERT INTO PRODUCT (PRODUCT_CODE, PRODUCT_NAME, PRODUCT_PRICE, ADULTS_ONLY, DESCRIPTION, PRODUCER_ID) VALUES" +
                    "(?, ?, ?, ?, ?, ?)";
            case PURCHASE -> "INSERT INTO PURCHASE (CUSTOMER_ID, PRODUCT_ID, QUANTITY, DATE_TIME) VALUES" +
                        "(?, ?, ?, ?)";
        };
    }
}
