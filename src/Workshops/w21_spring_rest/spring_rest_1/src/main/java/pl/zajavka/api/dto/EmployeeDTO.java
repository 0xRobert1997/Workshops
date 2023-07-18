package pl.zajavka.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer employeeId;
    private String name;
    private String surname;
    private BigDecimal salary;
    private String phone;
    private String email;

    public Map<String, String> asMap() {
        Map<String, String> result = new HashMap<>();
        Optional.ofNullable(employeeId).ifPresent(value -> result.put("employeeId", value.toString()));
        Optional.ofNullable(name).ifPresent(value -> result.put("name", value));
        Optional.ofNullable(surname).ifPresent(value -> result.put("surname", value));
        Optional.ofNullable(salary).ifPresent(value -> result.put("salary", value.toString()));
        Optional.ofNullable(phone).ifPresent(value -> result.put("phone", value));
        Optional.ofNullable(email).ifPresent(value -> result.put("email", value));
        return result;
    }

}
