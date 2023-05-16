package springExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = ConfigScanBean.class)
public class SpringTextContextFrameworkExample {
    @Autowired
    private ExampleBeanService exampleBeanService;

    @BeforeEach
    public void setUp() {
        Assertions.assertNotNull(exampleBeanService);
    }

    @Test
    public void testSampleMethod() {
        boolean result = exampleBeanService.sampleMethod();
        Assertions.assertFalse(result);
    }
}
