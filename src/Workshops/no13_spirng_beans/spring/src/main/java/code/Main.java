package code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {

    /*
       @Configuration
       @Bean
    */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);
      //  ExampleBean exampleBean = context.getBean(ExampleBean.class);
        Arrays.asList(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
     //   exampleBean.exampleMethod();
    }
}
