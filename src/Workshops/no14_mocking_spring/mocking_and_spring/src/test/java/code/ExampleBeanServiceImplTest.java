package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ExampleBeanServiceImplTest {
    // jeżeli w given nie określimy jak zaślepka ma się zachowywać to mockito zwraca nulla


    // do klas pod @InjectetMocks będą wstrzyknięte klasy podane pod @Mock
    @InjectMocks
    private ExampleBeanServiceImpl exampleBeanService;

    @Mock
    private InjectedBeanService injectedBeanService;

/*
    Zamiast adnotacji @InjectMock i @Mock można po prostu użyć beforeEach
    @BeforeEach
    void init() {
        this.injectedBeanService = Mockito.mock(InjectedBeanService.class);
        this.exampleBeanService = new ExampleBeanServiceImpl();
        this.exampleBeanService.setInjectedBeanService(injectedBeanService);
    }
*/


    @ParameterizedTest
    @MethodSource
    void sampleMethod(String val1, String val2) {
        // given
        // Mockito.when(injectedBeanService.anotherSampleMethod(ArgumentMatchers.any())).thenReturn("something");
        // alternatywny sposób zapisu, ale zapis powyżej daje dodatkowe sprawdzenie poprawności typów a zapis poniżej nie
        // Mockito.doReturn("some Value").when(injectedBeanService).anotherSampleMethod(ArgumentMatchers.anyString());
        Mockito.when(injectedBeanService.anotherSampleMethod()).thenReturn(val1);
        Mockito.when(injectedBeanService.anotherSampleMethod()).thenReturn(val2);


        //when
        String result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertTrue(true, result);

        //   Mockito.verify(injectedBeanService, Mockito.times(1)).anotherSampleMethod(ArgumentMatchers.any());
        //   Mockito.verify(injectedBeanService, Mockito.never()).anotherSampleMethod(ArgumentMatchers.any());
        //   Mockito.verifyNoMoreInteractions(injectedBeanService);
        //   Mockito.verifyNoInteractions(injectedBeanService);

    }

    static Stream<Arguments> sampleMethod() {
        return Stream.of(
                Arguments.of("val1", "val2"),
                Arguments.of("val3", "val4"),
                Arguments.of("val5", "val6")
        );
    }


}

