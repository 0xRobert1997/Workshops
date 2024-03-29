package pl.zajavka.controller.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.zajavka.controller.dto.EmployeeDTO;
import pl.zajavka.controller.dto.EmployeeMapper;
import pl.zajavka.util.DtoFixtures;
import pl.zajavka.util.EntityFixtures;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeesControllerMockitoTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeesController employeesController;

    @Test
    void thatRetrievingEmployeeWorksCorrectly() {
        //given
        Integer employeeId = 10;
        EmployeeEntity employeeEntity = EntityFixtures.someEmployee1();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeEntity));
        when(employeeMapper.map(employeeEntity)).thenReturn(DtoFixtures.someEmployee1());
        //when
        EmployeeDTO result = employeesController.employeeDetails(employeeId);
        //then
        Assertions.assertThat(result).isEqualTo(DtoFixtures.someEmployee1());
    }

    @Test
    void thatSavingEmployeeWorksCorrectly() {
        //given
        when(employeeRepository.save(any(EmployeeEntity.class)))
                .thenReturn(EntityFixtures.someEmployee1().withEmployeeId(123));
        //when
        ResponseEntity<?> result = employeesController.addEmployee(DtoFixtures.someEmployee1());
        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}