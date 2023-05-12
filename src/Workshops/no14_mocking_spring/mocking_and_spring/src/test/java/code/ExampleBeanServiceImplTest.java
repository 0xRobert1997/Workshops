package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExampleBeanServiceImplTest {
    // jeżeli w given nie określimy jak zaślepka ma się zachowywać to mockito zwraca nulla

    //                        jeśli w teście wywołamy tą metodę i wpadnie do niej cokolwiek to zwróci "something"
    // Mockito.when(injectedBeanService.anotherSampleMethod(ArgumentMatchers.any())).thenReturn("something");

    // do klas pod @InjectetMocks będą wstrzyknięte klasy podane pod @Mock
    @InjectMocks
    private ExampleBeanServiceImpl exampleBeanService;

    @Mock
    private InjectedBeanService injectedBeanService;

    @Test
    void sampleMethod() {
        // given
        Mockito.when(injectedBeanService.anotherSampleMethod(ArgumentMatchers.any())).thenReturn("something");

        // alternatywny sposób zapisu, ale zapis powyżej daje dodatkowe sprawdzenie poprawności typów a zapis poniżej nie
        Mockito.doReturn("some Value").when(injectedBeanService).anotherSampleMethod(ArgumentMatchers.anyString());

        //when
        String result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertTrue(true);

        Mockito.verify(injectedBeanService, Mockito.times(1)).anotherSampleMethod(ArgumentMatchers.any());
        Mockito.verify(injectedBeanService, Mockito.never()).anotherSampleMethod(ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(injectedBeanService);
        Mockito.verifyNoInteractions(injectedBeanService);

    }


}

