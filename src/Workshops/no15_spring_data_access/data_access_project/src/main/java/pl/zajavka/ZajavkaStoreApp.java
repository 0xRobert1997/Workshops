package pl.zajavka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.Configuration.DatabaseConfiguration;
import pl.zajavka.business.ReloadDataService;

public class ZajavkaStoreApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
        ReloadDataService bean = context.getBean(ReloadDataService.class);

        bean.loadRandomData();

    }
}
