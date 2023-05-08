import code.InjectedBean;
import configuration.ExampleConfigurationClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

public class Main {

    /*
       @Configuration
       @Bean

       Stereotypes
       @Component - basic bean
       @Service - logika biznesowa
       @Repository - komunikacja z bazą danych
       @Controller - do naszego api

       component scanning
       - @ComponentScan(basePackages = "code")
       - @ComponentScan(basePackageClasses = MarkerInterface.class)

       automatic beans binding
    */
    public static void main(String[] args) {

        System.out.println("### Before context");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);
        System.out.println("### After context");

        //    Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("### Before retrival");
        InjectedBean exampleBean = context.getBean(InjectedBean.class);
        System.out.println("### After retrival");

        System.out.println("### Before calling method");
        exampleBean.someMethod();
        System.out.println("### After calling method");

        System.out.println("### Before context closing");
        context.close();
        System.out.println("### After context closing");
    }
}
