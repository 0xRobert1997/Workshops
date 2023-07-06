package code.controller;

import code.infrastructure.database.entity.EmployeeEntity;
import code.infrastructure.database.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    // powinien być wstrzyknięty service ale pokazujemy tutaj działanie thymeleaf'a i to omijamy
    private final EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public String addEmployee(
        @RequestParam(value = "name") String name,
        @RequestParam(value = "surname") String surname,
        @RequestParam(value = "salary") String salary
    ) {
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .name(name)
                .surname(surname)
                .salary(new BigDecimal(salary))
                .build();
        employeeRepository.save(newEmployee);
        //return "employees";
        return "redirect:/employees";
    }

    @GetMapping
    public String employees(Model model) {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        // nazwa atrybutu żeby się odwoływać w widoku (linijka 38 w employees.html)
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/show/{employeeId}")
    public String showEmployeeDetails(
            @PathVariable Integer employeeId,
            Model model
    ) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId: [%s]".formatted(employeeId)
                ));
        model.addAttribute("employee", employeeEntity);
        model.addAttribute("updateEmployeeDTO", new UpdateEmployeeDTO());
        return "employeeDetails";
    }
    @PutMapping("/update")
    public String updateEmployee(
            @ModelAttribute("updateEmployeeDTO") UpdateEmployeeDTO updateEmployeeDTO
    ) {
        EmployeeEntity employeeEntity = employeeRepository.findById(updateEmployeeDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "EmployeeEntity not found, employeeId: [%s]".formatted(updateEmployeeDTO.getEmployeeId())
                ));

        employeeEntity.setName(updateEmployeeDTO.getName());
        employeeEntity.setSurname(updateEmployeeDTO.getSurname());
        employeeEntity.setSalary(updateEmployeeDTO.getSalary());
        employeeRepository.save(employeeEntity);
        return "redirect:/employees";
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return "redirect:/employees";
    }

}
