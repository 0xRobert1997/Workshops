package anotherSpringExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestBeanConfiguration.class})
class CapacityCalculationServiceImplTest {

    @Autowired
    private CapacityCalculationService capacityCalculationService;
    @Autowired
    private WidthCalculationService widthCalculationService;
    @Autowired
    private DepthCalculationService depthCalculationService;
    @Autowired
    private HeightCalculationService heightCalculationService;

    @BeforeEach
    void setUp() {
        Assertions.assertNotNull(capacityCalculationService);
        Assertions.assertNotNull(widthCalculationService);
        Assertions.assertNotNull(depthCalculationService);
        Assertions.assertNotNull(heightCalculationService);
    }

    @Test
    void someCalculation() {
        //given
        final var inputData = someInputData();
        Mockito.when(widthCalculationService.calculate(Mockito.any(InputData.class)))
                .thenReturn(BigDecimal.TEN);
        Mockito.when(depthCalculationService.calculate(Mockito.any(InputData.class)))
                .thenReturn(BigDecimal.TEN);
        //when
        final var result = capacityCalculationService.someCalculation(inputData);
        //then
        Assertions.assertEquals(new BigDecimal("300"), result);
    }


    private InputData someInputData() {
        return InputData.builder()
                .depth("1")
                .width("2")
                .height("3")
                .build();
    }
}