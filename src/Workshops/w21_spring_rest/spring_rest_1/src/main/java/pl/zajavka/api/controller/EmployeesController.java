package pl.zajavka.api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajavka.api.dto.EmployeeDTO;
import pl.zajavka.api.dto.EmployeeMapper;
import pl.zajavka.api.dto.EmployeesDTO;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.net.URI;

import static pl.zajavka.api.controller.EmployeesController.EMPLOYEES;

@RestController
@RequestMapping(EMPLOYEES)
@AllArgsConstructor
public class EmployeesController {

    public static final String EMPLOYEES = "/employees";
    public static final String EMPLOYEE_ID = "/{employeeId}";
    public static final String EMPLOYEE_ID_RESULT = "/%s";

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    // localhost:8087/zajavka/employees
    @GetMapping
    public EmployeesDTO employeesList() {
        return EmployeesDTO.of(employeeRepository.findAll().stream()
                .map(a -> employeeMapper.map(a))
                .toList());
    }

    // localhost:8087/zajavka/employees/{employeeId}
    // localhost:8087/zajavka/employees/1
    @GetMapping(value = EMPLOYEE_ID, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EmployeeDTO employeeDetails(
            @PathVariable Integer employeeId
    ) {
        return employeeRepository.findById(employeeId)
                .map(a -> employeeMapper.map(a))
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId: [%s]".formatted(employeeId)
                ));
    }

    // bez dopisku bo będzie na endpoincie /employees
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .salary(employeeDTO.getSalary())
                .phone(employeeDTO.getPhone())
                .email(employeeDTO.getEmail())
                .build();
        EmployeeEntity created = employeeRepository.save(employeeEntity);
        return ResponseEntity
                .created(URI.create(EMPLOYEES + EMPLOYEE_ID_RESULT.formatted(created.getEmployeeId())))
                .build();
    }

    @PutMapping(EMPLOYEE_ID)
    public ResponseEntity<?> updateEmployee(
            @PathVariable Integer employeeId,
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId [%s]".formatted(employeeId)
                ));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSurname(employeeDTO.getSurname());
        existingEmployee.setSalary(employeeDTO.getSalary());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(existingEmployee);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(EMPLOYEE_ID)
    public ResponseEntity<?> deleteEmployee(
        @PathVariable Integer employeeId
    ){
        // najpierw szukamy pracownika bo deleteById nie zwraca info czy się udało
        var employeeOpt = employeeRepository.findById(employeeId);

        if (employeeOpt.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
