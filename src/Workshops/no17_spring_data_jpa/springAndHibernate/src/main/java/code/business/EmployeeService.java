package code.business;

import code.infrastructure.database.jpaRepositories.EmployeeDataJpaRepository;
import code.infrastructure.database.model.EmployeeEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeDataJpaRepository employeeDataJpaRepository;

    @Transactional
    public void runSuccessful() {
        employeeDataJpaRepository.deleteAll();
        employeeDataJpaRepository.flush();

        EmployeeEntity employee1 = employeeDataJpaRepository.save(EmployeeData.someEmployee1());
        EmployeeEntity employee2 = employeeDataJpaRepository.save(EmployeeData.someEmployee2());
        EmployeeEntity employee3 = employeeDataJpaRepository.save(EmployeeData.someEmployee3());

        System.out.println("###Employee 1: " + employeeDataJpaRepository.findById(employee1.getEmployeeId()));
        System.out.println("###Employee 2: " + employeeDataJpaRepository.findById(employee2.getEmployeeId()));

        EmployeeEntity employeeBeforeUpdate = employeeDataJpaRepository.findById(employee3.getEmployeeId()).orElseThrow();
        employeeBeforeUpdate.setSalary(new BigDecimal("666"));
        employeeDataJpaRepository.saveAndFlush(employeeBeforeUpdate);

        employeeDataJpaRepository.findAll()
                .forEach(employee -> System.out.println("###Employee: " + employee));

        employeeDataJpaRepository.deleteById(employee2.getEmployeeId());

        employeeDataJpaRepository.findAll()
                .forEach(employee -> System.out.println("###Employee: " + employee));
    }

    @Transactional
    public void testTransactional() {
        employeeDataJpaRepository.deleteAll();

        employeeDataJpaRepository.saveAll(
                List.of(
                        EmployeeData.someEmployee1(),
                        EmployeeData.someEmployee2(),
                        EmployeeData.someEmployee3()
                )
        );

    }
}
