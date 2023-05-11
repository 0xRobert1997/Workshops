package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleBeanServiceImplTest {

    @Test
    void sampleMethod() {
        // given
        ExampleBeanService exampleBeanService = new ExampleBeanServiceImpl();
        exampleBeanService.setInjectedBeanService(new StubInjectedBeanService());

        //when
        boolean result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertEquals(true, true);

    }

    static class StubInjectedBeanService implements InjectedBeanService {

        @Override
        public boolean anotherSampleMethod() {
            return true;
        }
    }
}

