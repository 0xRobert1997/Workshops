package anotherSpringExample;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BeanConfiguration.class)
public class TestBeanConfiguration {

    @Mock
    private DepthCalculationService depthCalculationService;


    public TestBeanConfiguration() {
        try (AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this)) {
            System.out.println("Correctly opened mocks");
        } catch (Exception e) {
            System.err.println("unable to open mocks: " + e);
            throw new RuntimeException(e);
        }
    }

    @Bean
    public DepthCalculationService depthCalculationService() {
        return depthCalculationService;
    }

    @Bean
    public WidthCalculationService widthCalculationService() {
        return Mockito.mock(WidthCalculationService.class);
    }
}
