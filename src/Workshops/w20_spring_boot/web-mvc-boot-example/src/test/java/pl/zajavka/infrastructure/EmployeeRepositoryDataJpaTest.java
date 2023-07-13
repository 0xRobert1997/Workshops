package pl.zajavka.infrastructure;

import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.util.List;

import static pl.zajavka.util.EntityFixtures.*;

/*@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.yaml")*/
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeRepositoryDataJpaTest extends AbstractJpaIT {

    private EmployeeRepository employeeRepository;

    @Test
    void ThatEmployeeCanBeSavedCorrectly() {
        //given
        var employees = List.of(someEmployee1(), someEmployee2(), someEmployee3());
        employeeRepository.saveAllAndFlush(employees);
        //when
        List<EmployeeEntity> employeesFound = employeeRepository.findAll();
        //then
        Assertions.assertThat(employeesFound.size()).isEqualTo(3);
    }
}
