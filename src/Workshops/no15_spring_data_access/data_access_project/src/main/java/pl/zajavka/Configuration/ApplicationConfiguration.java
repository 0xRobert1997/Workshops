package pl.zajavka.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({DatabaseConfiguration.class})
@ComponentScan(basePackages = "pl.zajavka")
public class ApplicationConfiguration {
}
