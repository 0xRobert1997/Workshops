package pl.zajavka.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import static pl.zajavka.api.controller.EmployeesController.EMPLOYEES;

@RestController
@RequestMapping(EMPLOYEES)
public class EmployeesController {

    public static final String EMPLOYEES = "/employees";

    @PostMapping
    public ResponseEntity<?> addEmployee(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "salary") String salary
    ) {
        return null;
    }

    @GetMapping("/show/{employeeId}")
    public ResponseEntity<?> showEmployeeDetails(
            @PathVariable Integer employeeId
    ) {
        return null;
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable Integer employeeId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String salary
    ) {
        return null;
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(
            @PathVariable Integer employeeId
    ) {
        return null;
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<?> partiallyUpdateEmployee(
            @PathVariable Integer employeeId
    ) {
        return null;
    }

}
