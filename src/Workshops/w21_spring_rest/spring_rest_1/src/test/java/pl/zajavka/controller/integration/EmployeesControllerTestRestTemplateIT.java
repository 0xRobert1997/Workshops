package pl.zajavka.controller.integration;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import pl.zajavka.controller.dto.EmployeesDTO;
import pl.zajavka.controller.integration.configuration.AbstractIntegrationTest;
import pl.zajavka.util.DtoFixtures;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeesControllerTestRestTemplateIT extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate testRestTemplate;

    @Test
    public void thatEmployeesListingWorksCorrectly() {
        String url = "http://localhost:%s/zajavka/employees".formatted(port);

        this.testRestTemplate.postForEntity(url, DtoFixtures.someEmployee1(), EmployeesDTO.class);

        ResponseEntity<EmployeesDTO> result = this.testRestTemplate.getForEntity(url, EmployeesDTO.class);
        EmployeesDTO body = result.getBody();
        Assertions.assertThat(body).isNotNull();
        Assertions.assertThat(body.getEmployees()).hasSizeGreaterThan(0);
    }
}
