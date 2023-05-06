package code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
       automatic beans binding
    */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);
        InjectedBean exampleBean = context.getBean(InjectedBean.class);
      //  Arrays.asList(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
        exampleBean.someMethod();
    }
}
