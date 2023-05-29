package pl.zajavka.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import pl.zajavka.Configuration.DatabaseConfiguration;
import pl.zajavka.business.CustomerRepository;
import pl.zajavka.domain.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class CustomerDatabaseRepository implements CustomerRepository {
    private static final String SELECT_ALL = "SELECT * FROM CUSTOMER";
    private static final String DELETE_ALL = "DELETE FROM CUSTOMER WHERE 1=1";
    private static final String SELECT_ONE_WHERE_EMAIL = "SELECT * FROM CUSTOMER WHERE EMAIL = :email";
    private static final String DELETE_WHERE_CUSTOMER_EMAIL = "DELETE FROM CUSTOMER WHERE EMAIL = :email";
    private final SimpleDriverDataSource simpleDriverDataSource;
    private final DataBaseMapper dataBaseMapper;

    @Override
    public Customer create(Customer customer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.CUSTOMER_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.CUSTOMER_TABLE_PKEY);

        Number customerId = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(customer));
        return customer.withId(customerId.longValue());
    }

    @Override
    public Optional<Customer> find(String email) {
        final var jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);

        try {
            Map<String, Object> params = Map.of("email", email);
            return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_ONE_WHERE_EMAIL, params, dataBaseMapper::mapCustomer));
        } catch (Exception e) {
            log.warn("Trying to find non-existing customer: [{}]", email);
            return Optional.empty();
        }
    }

    @Override
    public void removeAll() {
        new JdbcTemplate(simpleDriverDataSource).update(DELETE_ALL);
    }

    @Override
    public void remove(String email) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);
        jdbcTemplate.update(DELETE_WHERE_CUSTOMER_EMAIL, Map.of("email", email));

    }

    @Override
    public List<Customer> findAll(String email) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        return jdbcTemplate.query(SELECT_ALL, dataBaseMapper::mapCustomer);
    }

    @Override
    public List<Customer> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        return jdbcTemplate.query(SELECT_ALL, dataBaseMapper::mapCustomer);
    }
}
