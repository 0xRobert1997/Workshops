package pl.zajavka.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.zajavka.CarDealershipApplication;

@Configuration
public class SpringDocConfiguration {

    // beany do wystawienia swagger ui

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch("/**")
                .packagesToScan(CarDealershipApplication.class.getPackageName())
                .build();
    }

    @Bean
    public OpenAPI springDocOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Employee application")
                        .contact(contact())
                        .version("1.0"));

    }

    private Contact contact() {
        return new Contact()
                .name("Test")
                .url("https://test.pl")
                .email("kontakt@kontakt.pl");
    }
}
