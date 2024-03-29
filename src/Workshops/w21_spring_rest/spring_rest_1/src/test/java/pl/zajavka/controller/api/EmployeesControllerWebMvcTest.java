package pl.zajavka.controller.api;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.zajavka.controller.dao.PetDao;
import pl.zajavka.controller.dto.EmployeeDTO;
import pl.zajavka.controller.dto.EmployeeMapper;
import pl.zajavka.util.DtoFixtures;
import pl.zajavka.util.EntityFixtures;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;
import pl.zajavka.infrastructure.database.repository.PetRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmployeesController.class)
@AutoConfigureMockMvc(addFilters = false)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeesControllerWebMvcTest {

    private final MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;
    @MockBean
    private PetRepository petRepository;
    @MockBean
    private PetDao petDao;
    @MockBean
    private EmployeeMapper employeeMapper;

    @Test
    public void thatEmployeeCanBeRetrieved() throws Exception {
        //given
        int employeeId = 123;
        EmployeeEntity employeeEntity = EntityFixtures.someEmployee1().withEmployeeId(employeeId);
        EmployeeDTO employeeDTO = DtoFixtures.someEmployee1().withEmployeeId(employeeId);

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeEntity));
        Mockito.when(employeeMapper.map(Mockito.any(EmployeeEntity.class))).thenReturn(employeeDTO);

        //when, then
        String endpoint = EmployeesController.EMPLOYEES + EmployeesController.EMPLOYEE_ID;
        mockMvc.perform(MockMvcRequestBuilders.get(endpoint, employeeId))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId", Matchers.is(employeeDTO.getEmployeeId())))
                .andExpect(jsonPath("$.name", Matchers.is(employeeDTO.getName())))
                .andExpect(jsonPath("$.surname", Matchers.is(employeeDTO.getSurname())))
                .andExpect(jsonPath("$.salary", Matchers.is(employeeDTO.getSalary()), BigDecimal.class))
                .andExpect(jsonPath("$.phone", Matchers.is(employeeDTO.getPhone())))
                .andExpect(jsonPath("$.email", Matchers.is(employeeDTO.getEmail())));
    }

    @Test
    void thatEmailValidationWorksCorrectly() throws Exception {
        //given
        final var request = """
                {
                    "email": "badEmail"
                }
                """;

        //when, then
        mockMvc.perform(
                post(EmployeesController.EMPLOYEES)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errorId", Matchers.notNullValue()));
    }

    @ParameterizedTest
    @MethodSource
    void thatPhoneValidationWorksCorrectly(Boolean correctPhone, String phone) throws Exception {
        //given
        final var request = """
                {
                    "phone": "%s"
                }
                """.formatted(phone);

        Mockito.when(employeeRepository.save(Mockito.any(EmployeeEntity.class)))
                .thenReturn(EntityFixtures.someEmployee1().withEmployeeId(124));

        // when, then
            if (correctPhone) {
                String expectedRedirect = EmployeesController.EMPLOYEES
                        + EmployeesController.EMPLOYEE_ID_RESULT.formatted(124);
                mockMvc.perform(post(EmployeesController.EMPLOYEES)
                        .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                        .andExpect(status().isCreated())
                        .andExpect(redirectedUrl(expectedRedirect));
            } else {
                mockMvc.perform(post(EmployeesController.EMPLOYEES)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                        .andExpect(status().isBadRequest())
                        .andExpect(jsonPath("$.errorId", Matchers.notNullValue()));
            }
    }

    public static Stream<Arguments> thatPhoneValidationWorksCorrectly() {
        return Stream.of(
                Arguments.of(false, ""),
                Arguments.of(false, "+48 504 203 260@@"),
                Arguments.of(false, "+48.504.203.260"),
                Arguments.of(false, "+55(123) 456-78-90-"),
                Arguments.of(false, "+55(123) - 456-78-90"),
                Arguments.of(false, "504.203.260"),
                Arguments.of(false, " "),
                Arguments.of(false, "-"),
                Arguments.of(false, "()"),
                Arguments.of(false, "() + ()"),
                Arguments.of(false, "(21 7777"),
                Arguments.of(false, "+48 (21)"),
                Arguments.of(false, "+"),
                Arguments.of(false , " 1"),
                Arguments.of(false , "1"),
                Arguments.of(false, "555-5555-555"),
                Arguments.of(false, "+48 (12) 504 203 260"),
                Arguments.of(false, "+48 (12) 504-203-260"),
                Arguments.of(false, "+48(12)504203260"),
                Arguments.of(false, "+4812504203260"),
                Arguments.of(true, "+48 504 203 260")
        );
    }

}
