package pl.zajavka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.Configuration.DatabaseConfiguration;

public class ZajavkaStoreApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
        RandomDataService bean = context.getBean(RandomDataService.class);

     //   bean.fillDataBaseWithRandomData();


    }
}
