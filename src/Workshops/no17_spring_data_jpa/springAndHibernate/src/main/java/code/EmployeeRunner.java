package code;

import code.business.EmployeeService;
import code.infrastructure.configuration.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        EmployeeService employeeService = context.getBean(EmployeeService.class);


    }
}
