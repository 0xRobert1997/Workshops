package code.business;

import code.infrastructure.configuration.ApplicationConfiguration;
import code.infrastructure.database.jpaRepositories.EmployeeDataJpaRepository;
import code.infrastructure.database.model.EmployeeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Testcontainers
@SpringJUnitConfig(classes = {ApplicationConfiguration.class})
class EmployeeServiceTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15.0");

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        registry.add("jdbc.url", postgreSQLContainer::getJdbcUrl);
        registry.add("jdbc.user", postgreSQLContainer::getUsername);
        registry.add("jdbc.pass", postgreSQLContainer::getPassword);
    }
    @Autowired
    private EmployeeService employeeService;

    @Test
    void firstTestForEmployeeFunctionality() {
        //given
        employeeService.create(SomeEmployee());
        //when
        List<EmployeeEntity> allEmployees = employeeService.findAll();
        //then
        Assertions.assertEquals(1, allEmployees.size());
    }

    private EmployeeEntity SomeEmployee() {
        return EmployeeEntity.builder()
                .name("Tomek")
                .surname("Romek")
                .salary(BigDecimal.TEN)
                .since(OffsetDateTime.of(2010, 1, 1, 1, 0,0,0, ZoneOffset.UTC))
                .build();
    }
}