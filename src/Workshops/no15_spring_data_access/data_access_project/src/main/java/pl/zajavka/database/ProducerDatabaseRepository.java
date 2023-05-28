package pl.zajavka.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import pl.zajavka.Configuration.DatabaseConfiguration;
import pl.zajavka.business.ProducerRepository;
import pl.zajavka.domain.Producer;

@Slf4j
@Repository
@AllArgsConstructor
public class ProducerDatabaseRepository implements ProducerRepository {
    private final SimpleDriverDataSource simpleDriverDataSource;

    private static final String DELETE_ALL = "DELETE FROM PRODUCER WHERE 1=1";

    @Override
    public Producer create(Producer producer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.PRODUCER_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.PRODUCER_TABLE_PKEY);

        Number producerId = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(producer));
        return producer.withId(producerId.longValue());
    }

    @Override
    public void removeAll() {
        new JdbcTemplate(simpleDriverDataSource).update(DELETE_ALL);
    }
}
