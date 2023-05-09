package configuration;

import code.InjectedBean;
import code.MarkerInterface;
import code.SomeBean1;
import code.SomeCommonInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "code")                       //musi być podana nazwa paczki
@ComponentScan(basePackageClasses = MarkerInterface.class) // albo można wzkazać marker/main i to wskazuje na to że Spring skanuje paczke w której znajduje się ten interface
public class ExampleConfigurationClass {


    // ustawienie powiązań bez użycia adnotacji
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

    // jeżeli zamiast adnotacji @Qualifier użyjemy metody w klasie konfiguracyjnej to dany bean będzie się nazywał tak jak nazwa metody
    /*@Bean
    public SomeCommonInterface someBeanMyName() {
        return new SomeBean1();
    }*/

   /* @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public InjectedBean injectedBean() {
        return new InjectedBean();
    }*/

}
