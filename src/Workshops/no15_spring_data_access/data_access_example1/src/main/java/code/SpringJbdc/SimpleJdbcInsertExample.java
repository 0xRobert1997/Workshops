package code.SpringJbdc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SimpleJdbcInsertExample {

    private final SimpleDriverDataSource simpleDriverDataSource;

    public void simpleJdbcInsertExample() {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource);
        simpleJdbcInsert.setTableName("Person");

        Person person = Person.builder()
                .id(39L)
                .name("Stefan")
                .age(44)
                .build();
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(person);
        int result = simpleJdbcInsert.execute(parameterSource);

/*        Map<String, Object> params = new HashMap<>();
        params.put("ID", 12);
        params.put("NAME", "Karol");
        params.put("AGE", 19);
        int result = simpleJdbcInsert.execute(params);*/


        System.out.println(result);
    }
}
