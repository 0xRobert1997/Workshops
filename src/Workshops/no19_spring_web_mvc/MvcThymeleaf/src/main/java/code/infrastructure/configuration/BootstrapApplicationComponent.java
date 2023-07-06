package code.infrastructure.configuration;

import code.infrastructure.database.entity.EmployeeEntity;
import code.infrastructure.database.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class BootstrapApplicationComponent implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeRepository employeeRepository;
    @Override
    @Transactional
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        employeeRepository.deleteAll();

        employeeRepository.save(EmployeeEntity
                .builder()
                .name("Stefan")
                .surname("Zajavka")
                .salary(new BigDecimal("123"))
                .build());
        employeeRepository.save(EmployeeEntity
                .builder()
                .name("Agnieszka")
                .surname("Spring")
                .salary(new BigDecimal("456"))
                .build());
        employeeRepository.save(EmployeeEntity
                .builder()
                .name("Tomasz")
                .surname("Hibernate")
                .salary(new BigDecimal("789"))
                .build());
    }
}
