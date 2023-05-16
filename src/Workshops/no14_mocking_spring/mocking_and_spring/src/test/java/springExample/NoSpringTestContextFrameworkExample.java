package springExample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoSpringTestContextFrameworkExample {

    private ExampleBeanService exampleBeanService;

    @BeforeEach
    public void setUp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigScanBean.class);
        exampleBeanService = applicationContext.getBean(ExampleBeanService.class);
        Assertions.assertNotNull(exampleBeanService);
    }

    @AfterEach
    public void tearDown() {
        exampleBeanService = null;
        Assertions.assertNull(exampleBeanService);
    }

    @Test
    public void testSampleMethod() {
        boolean result = exampleBeanService.sampleMethod();
        Assertions.assertFalse(result);
    }
}
