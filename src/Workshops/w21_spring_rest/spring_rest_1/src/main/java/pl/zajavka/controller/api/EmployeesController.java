package pl.zajavka.controller.api;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajavka.controller.dao.PetDao;
import pl.zajavka.controller.dto.EmployeeDTO;
import pl.zajavka.controller.dto.EmployeeMapper;
import pl.zajavka.controller.dto.EmployeesDTO;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.entity.PetEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;
import pl.zajavka.infrastructure.database.repository.PetRepository;
import pl.zajavka.infrastructure.petstore.Pet;

import java.math.BigDecimal;

import static pl.zajavka.controller.api.EmployeesController.EMPLOYEES;

@RestController
@RequestMapping(EMPLOYEES)
@AllArgsConstructor
public class EmployeesController {

    public static final String EMPLOYEES = "/employees";
    public static final String EMPLOYEE_ID = "/{employeeId}";
    public static final String EMPLOYEE_UPDATE_SALARY = "/{employeeId}/salary";
    public static final String EMPLOYEE_ID_RESULT = "/%s";

    public static final String EMPLOYEE_UPDATE_PET = "/{employeeId}/pet/{petId}";

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private PetDao petDao;
    private PetRepository petRepository;


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

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", EMPLOYEES + EMPLOYEE_ID_RESULT.formatted(created.getEmployeeId()));

        return new ResponseEntity<>(
                headers,
                HttpStatus.CREATED
        );
/*        return ResponseEntity
                .created(URI.create(EMPLOYEES + EMPLOYEE_ID_RESULT.formatted(created.getEmployeeId())))
                .build();*/
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
    ) {
        // najpierw szukamy pracownika bo deleteById nie zwraca info czy się udało
        var employeeOpt = employeeRepository.findById(employeeId);

        if (employeeOpt.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(EMPLOYEE_UPDATE_SALARY)
    public ResponseEntity<?> updateEmployeeSalary(
            @PathVariable Integer employeeId,
            @RequestParam(required = true) BigDecimal newSalary
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId [%s]".formatted(employeeId)
                ));
        existingEmployee.setSalary(newSalary);
        employeeRepository.save(existingEmployee);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(EMPLOYEE_UPDATE_PET)
    public ResponseEntity<?> updateEmployeeWithPet(
            @PathVariable Integer employeeId,
            @PathVariable Integer petId
    ) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId [%s]".formatted(employeeId)
                ));

        Pet petFromStore = petDao.getPet(Long.valueOf(petId))
                .orElseThrow(() -> new RuntimeException(
                        "Pet with id: [%s] could not be retrieved".formatted(petId)
                ));

        PetEntity newPet = PetEntity.builder()
                .petStorePetId(petFromStore.getId())
                .name(petFromStore.getName())
                .status(petFromStore.getStatus())
                .employee(existingEmployee)
                .build();

        petRepository.save(newPet);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "test-header")
    public ResponseEntity<?> testHeader(
            @RequestHeader(value = HttpHeaders.ACCEPT) MediaType accept,
            @RequestHeader(value = "httpStatus", required = true) int httpStatus
    ) {
        return ResponseEntity
                .status(httpStatus)
                .body("Accepted: " + accept);   // w body możemy przekazać stringa, jak przekażemy obiekt to zostanie zamieniony na json'a

    }

}
