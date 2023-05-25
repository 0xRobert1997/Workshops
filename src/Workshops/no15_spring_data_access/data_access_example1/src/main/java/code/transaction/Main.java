package code.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        TransactionExample jdbcTemplateExamples = context.getBean(TransactionExample.class);
        //jdbcTemplateExamples.example1();
        jdbcTemplateExamples.someMethod();
    }
}
