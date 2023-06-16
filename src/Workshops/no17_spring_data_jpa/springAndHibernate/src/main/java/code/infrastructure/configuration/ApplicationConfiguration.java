package code.infrastructure.configuration;

import code.EmployeeRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = EmployeeRunner.class)
@Import(code.infrastructure.configuration.PersistenceJPAConfiguration.class)
public class ApplicationConfiguration {
}
