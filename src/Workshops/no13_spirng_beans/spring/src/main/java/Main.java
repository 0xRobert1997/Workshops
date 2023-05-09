import code.ExamplePrototypeBean;
import code.ExampleSingletonBean;
import configuration.ExampleConfigurationClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

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
       @Autowire

       Scopes
        - Singleton domyślnie wszystkie beany są singleton'em
        - Prototype - za każdym razem tworzony jest nowy obiekt, może dzięki temu przechowywać jakąś wartość

        scoped bean injection problem
            gdy w singletonie jest pole z prototype to prototype jest zawsze ten sam - czyli nie zachowuje się jak normalny Prototype
            można użyć ObjectFactory<PrototypeBean>

    */
    public static void main(String[] args) {

        System.out.println("### Before context");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);
        System.out.println("### After context");

        //    Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

        ExampleSingletonBean singleton1 = context.getBean(ExampleSingletonBean.class);
        ExampleSingletonBean singleton2 = context.getBean(ExampleSingletonBean.class);

        ExamplePrototypeBean prototype1 = context.getBean(ExamplePrototypeBean.class);
        ExamplePrototypeBean prototype2 = context.getBean(ExamplePrototypeBean.class);

        System.out.println();
    }
}
