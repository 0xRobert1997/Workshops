package code.manyToMany;

import code.HibernateUtil;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

public class ManyToManyRunner {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.deleteAll();

        List<Employee> employeesCreated = createEmployees(employeeRepository);

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee listing: " + employee));

        System.out.println("###Employee 1: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 1).getEmployeeId()));

        System.out.println("###Employee 2: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 2).getEmployeeId()));

        updateEmployees(employeeRepository, employeesCreated);
        employeeRepository.listEmployees()
                .forEach(e -> System.out.println("###Employee listing: " + e));
        employeeRepository.deleteEmployee(employeesCreated
                .get(employeesCreated.size() - 2).getEmployeeId());
        employeeRepository.listEmployees()
                .forEach(e -> System.out.println("###Employee listing: " + e));

        HibernateUtil.closeSessionFactory();
    }

    private static List<Employee> createEmployees(final EmployeeRepository employeeRepository) {
        Project project1 = ExampleData.someProject1();
        Project project2 = ExampleData.someProject2();
        Project project3 = ExampleData.someProject3();
        Employee employee1 = ExampleData.someEmployee1();
        Employee employee2 = ExampleData.someEmployee2();
        Employee employee3 = ExampleData.someEmployee3();
        employee1.setProjects(Set.of(project1, project2));
        employee2.setProjects(Set.of(project2));
        employee3.setProjects(Set.of(project2, project3));
        return employeeRepository.insertData(List.of(employee1, employee2, employee3));
    }

    private static void updateEmployees(EmployeeRepository employeeRepository, List<Employee> employeesCreated) {
        Employee employeeToBeUpdated = employeesCreated.get(employeesCreated.size() - 1);
        Project newProject = Project.builder()
                .name("Something")
                .description("some description")
                .deadline(OffsetDateTime.of(2003, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
        employeeRepository.updateEmployee(employeeToBeUpdated.getEmployeeId(), newProject);
        System.out.println("###Employee update: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 1).getEmployeeId()));

    }
}
