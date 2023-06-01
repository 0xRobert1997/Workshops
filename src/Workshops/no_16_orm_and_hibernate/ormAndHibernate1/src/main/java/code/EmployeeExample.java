package code;

import java.math.BigDecimal;

public class EmployeeExample {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        employeeRepository.deleteAll();

        Employee employee1 = employeeRepository.insert(EmployeeData.someEmployee1());
        Employee employee2 = employeeRepository.insert(EmployeeData.someEmployee2());
        Employee employee3 = employeeRepository.insert(EmployeeData.someEmployee3());

        // mimo że po stworzeniu obiektu employee nie nadaliśmy mu id to po wsadzeniu do bazy danych ma już swój id
        employeeRepository.getEmployee(employee1.getEmployeeId());

        employeeRepository.updateEmployee(employee2.getEmployeeId(), new BigDecimal("420.69"));
    }
}
