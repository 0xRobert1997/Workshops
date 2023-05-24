package code.SpringJbdc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /*
        architektura trójwarstwowa - three-tier /
        warstwa
        -prezentacji
        -logiki biz
        -danych
        DAO - data access object

        Transaction
        ACID - atomicity(niepodzielność), Consistency(spójność), Isolation, Durability(trwałość)

        efekty współbieżności tranzakcji - występują przy niskim poziomie izolacji transakcji

        Dirty read
            gdy jedna transakcja może odczytywać dane z wiersza, który został
            zmodyfikowany przez inną działającą transakcję i nie został jeszcze zacommitowany
        Non-repeatable read
        Phantom read
     */
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        JdbcTemplateExample example = context.getBean(JdbcTemplateExample.class);
        example.insert();
/*        example.update();
        example.select();
        example.delete();*/

/*        SimpleJdbcInsertExample example = context.getBean(SimpleJdbcInsertExample.class);
        example.simpleJdbcInsertExample();*/

/*        NamedParameterJdbcTemplateExample example = context.getBean(NamedParameterJdbcTemplateExample.class);
        example.example();*/

    }
}
