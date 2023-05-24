package code.SpringJbdc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateExample {
    private final SimpleDriverDataSource simpleDriverDataSource;
    public void insert() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (?, ?)";
        jdbcTemplate.update(sql, "Roman", 30);

    }

    public void update() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "UPDATE PERSON SET AGE = ? WHERE NAME = ?";
        jdbcTemplate.update(sql, 40, "Roman");
    }

    public void select() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "SELECT * FROM PERSON";
       // sposób 1
        RowMapper<Person> personRowMapper = (resultSet, rowNum) -> Person.builder()
                .id(resultSet.getLong("ID"))
                .name(resultSet.getString("Name"))
                .age(resultSet.getInt("Age"))
                .build();

        List<Person> result1 = jdbcTemplate.query(sql, personRowMapper);
        System.out.println(result1);

        // sposób 2
        // użycie klasy springowej, jeśli nazwy pół klasy i nazwy kolumn są zgodne to sobie ogarnie sam
        BeanPropertyRowMapper<Person> personBeanPropertyRowMapper
                = BeanPropertyRowMapper.newInstance(Person.class);

        List<Person> result2 = jdbcTemplate.query(sql, personBeanPropertyRowMapper);
        System.out.println(result2);
    }

    public void delete() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql = "DELETE FROM PERSON WHERE NAME = ?";
        int result = jdbcTemplate.update(sql, "Roman");
        System.out.println(result);
    }
}
