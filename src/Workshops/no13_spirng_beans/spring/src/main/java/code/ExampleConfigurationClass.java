package code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfigurationClass {

    @Bean
    public ExampleBean exampleBean(InjectedBean injectedBean, AnotherInjectedBean anotherInjectedBean) {
        return new ExampleBean(injectedBean, anotherInjectedBean);
    }

    @Bean
    public InjectedBean injectedBean() {
        return new InjectedBean();
    }

    @Bean
    public AnotherInjectedBean anotherInjectedBean() {
        return new AnotherInjectedBean();
    }
}
