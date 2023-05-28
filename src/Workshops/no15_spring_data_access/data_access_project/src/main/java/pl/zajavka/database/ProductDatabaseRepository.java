package pl.zajavka.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import pl.zajavka.Configuration.DatabaseConfiguration;
import pl.zajavka.business.ProductRepository;
import pl.zajavka.domain.Product;

import java.util.Map;

@Slf4j
@Repository
@AllArgsConstructor
public class ProductDatabaseRepository implements ProductRepository {
    private final SimpleDriverDataSource simpleDriverDataSource;

    private final DataBaseMapper databaseMapper;

    private static final String DELETE_ALL = "DELETE FROM PRODUCT WHERE 1=1";

    @Override
    public Product create(Product product) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.PRODUCT_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.PRODUCT_TABLE_PKEY);

        Map<String, ?> params = databaseMapper.map(product);

        Number productId = jdbcInsert.executeAndReturnKey(params);
        return product.withId(productId.longValue());
    }

    @Override
    public void removeAll() {
        new JdbcTemplate(simpleDriverDataSource).update(DELETE_ALL);
    }
}
