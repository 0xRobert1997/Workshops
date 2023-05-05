package code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    /*
       konfiguracja jawna
             -pliki xml
             -oprata o javę

        konfiguracja nie-jawna - automatyczna
           -adnotacje

        */
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ExampleBean exampleBean = context.getBean("ExampleBean", ExampleBean.class);
        exampleBean.exampleMethod();
    }
}
