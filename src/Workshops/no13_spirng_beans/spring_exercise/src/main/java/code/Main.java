package code;

import code.Configuration.ApplicationConfiguration;
import code.service.MainProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        /*MainProcessor mainProcessor = new MainProcessor(
                new DataRepository(),
                new DataProcessingService(
                        new StringPreparationService())
        );
        mainProcessor.process();
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MainProcessor mainProcessor = context.getBean(MainProcessor.class);
        mainProcessor.process();
    }
}
