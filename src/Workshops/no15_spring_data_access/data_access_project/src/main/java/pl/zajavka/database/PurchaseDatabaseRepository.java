package pl.zajavka.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import pl.zajavka.Configuration.DatabaseConfiguration;
import pl.zajavka.business.PurchaseRepository;
import pl.zajavka.domain.Purchase;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@AllArgsConstructor
public class PurchaseDatabaseRepository implements PurchaseRepository {
    private static final String DELETE_ALL_WHERE_CUSTOMER_EMAIL =
            "DELETE FROM PURCHASE WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE EMAIL = :email)";;
    private static final String SELECT_ALL_WHERE_CUSTOMER_EMAIL =
            """
                    SELECT * FROM PURCHASE AS PUR
                    INNER JOIN CUSTOMER AS CUS ON CUS.ID = PUR.CUSTOMER_ID WHERE CUS.EMAIL = :email
                    ORDER BY DATE_TIME
                    """;
    private final SimpleDriverDataSource simpleDriverDataSource;
    private final DataBaseMapper databaseMapper;

    private static final String DELETE_ALL = "DELETE FROM PURCHASE WHERE 1=1";

    @Override
    public Purchase create(Purchase purchase) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.PURCHASE_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.PURCHASE_TABLE_PKEY);

        Map<String, ?> params = databaseMapper.map(purchase);

        Number purchaseId = jdbcInsert.executeAndReturnKey(params);
        return purchase.withId(purchaseId.longValue());
    }

    @Override
    public void removeAll() {
        new JdbcTemplate(simpleDriverDataSource).update(DELETE_ALL);
    }

    @Override
    public void removeAll(String email) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);
        jdbcTemplate.update(DELETE_ALL_WHERE_CUSTOMER_EMAIL, Map.of("email",email));
    }

    @Override
    public List<Purchase> findAll(String email) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);
        return jdbcTemplate.query(SELECT_ALL_WHERE_CUSTOMER_EMAIL, Map.of("email", email), databaseMapper::mapPurchase);
    }
}
