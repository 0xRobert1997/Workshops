package code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "code")                       //musi być podana nazwa paczki
@ComponentScan(basePackageClasses = MarkerInterface.class) // albo można wzkazać marker i to wskazuje na to że Spring skanuje paczke w której znajduje się ten interface
public class ExampleConfigurationClass {


/*    @Bean
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
    }*/
}
