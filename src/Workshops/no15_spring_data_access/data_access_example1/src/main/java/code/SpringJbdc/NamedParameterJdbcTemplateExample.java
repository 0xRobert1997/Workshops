package code.SpringJbdc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NamedParameterJdbcTemplateExample {
    private final SimpleDriverDataSource simpleDriverDataSource;

    void example() {
        NamedParameterJdbcTemplate template
                = new NamedParameterJdbcTemplate(simpleDriverDataSource);
        String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age)";

        //uzupełnianie values
        //sposób 1
/*        Map<String, Object> params1 = new HashMap<>();
        params1.put("name", "Romek");
        params1.put("age", 22);
        template.update(sql, params1);*/

        //sposób 2
/*        MapSqlParameterSource params2 = new MapSqlParameterSource()
                .addValue("name", "Tomek")
                .addValue("age", 88);

        template.update(sql, params2);*/

        //sposób 3
        Person person = Person.builder()
                .name("Agnieszka")
                .age(25)
                .build();
        BeanPropertySqlParameterSource params3 = new BeanPropertySqlParameterSource(person);
        template.update(sql, params3);
    }
}
