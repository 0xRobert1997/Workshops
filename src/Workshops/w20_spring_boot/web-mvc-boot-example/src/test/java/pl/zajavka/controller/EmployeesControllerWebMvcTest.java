package pl.zajavka.controller;

import lombok.AllArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.util.Map;
import java.util.stream.Stream;

// jak nie podamy tutaj którą klase dokładnie testujemy to spring bd podnosił ceontext na wszystkie controllery
@WebMvcTest(controllers = EmployeesController.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeesControllerWebMvcTest {

    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @ParameterizedTest
    @MethodSource
    void thatPhoneValidationWorksCorrectly(Boolean correctPhone, String phone) throws Exception {
        //given
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        Map<String, String> parametersMap = EmployeeDTO.builder().phone(phone).build().asMap();
        parametersMap.forEach(parameters::add);


        //when, then
        if (correctPhone) {
            mockMvc.perform(MockMvcRequestBuilders.post("/employees/add").params(parameters))
                    .andExpect(MockMvcResultMatchers.status().isFound())
                    .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("errorMessage"))
                    .andExpect(MockMvcResultMatchers.view().name("redirect:/employees"));
        } else {
            mockMvc.perform(MockMvcRequestBuilders.post("/employees/add").params(parameters))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andExpect(MockMvcResultMatchers.model().attributeExists("errorMessage"))
                    .andExpect(MockMvcResultMatchers.model().attribute("errorMessage", Matchers.containsString(phone)))
                    .andExpect(MockMvcResultMatchers.view().name("error"));
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
