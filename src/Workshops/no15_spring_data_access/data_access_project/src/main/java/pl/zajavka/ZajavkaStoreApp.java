package pl.zajavka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.Configuration.DatabaseConfiguration;
import pl.zajavka.business.RandomDataService;
import pl.zajavka.business.RandomDataService2;

public class ZajavkaStoreApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
        RandomDataService2 bean = context.getBean(RandomDataService2.class);

     //   bean.fillDataBaseWithRandomData();
            bean.create();

    }
}
