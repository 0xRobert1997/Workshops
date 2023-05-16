package springExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExampleBeanServiceImplTest {

    @InjectMocks
    private ExampleBeanService exampleBeanService;
    @Mock
    private InjectedBeanService injectedBeanService;

    @Test
    public void testSampleMEthod(){
        //given
        Mockito.when(injectedBeanService.anotherSampleMethod()).thenReturn(true);

        //when
        boolean result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertFalse(result);
    }
}
