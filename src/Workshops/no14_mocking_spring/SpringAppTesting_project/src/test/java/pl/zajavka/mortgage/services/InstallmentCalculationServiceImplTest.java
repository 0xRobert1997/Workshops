package pl.zajavka.mortgage.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zajavka.mortgage.fixtures.TestDataFixtures;
import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Installment;
import pl.zajavka.mortgage.model.InstallmentAmounts;
import pl.zajavka.mortgage.model.Overpayment;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class InstallmentCalculationServiceImplTest {

    @InjectMocks
    private InstallmentCalculationServiceImpl installmentCalculationService;
    @Mock
    private TimePointCalculationService timePointCalculationService;
    @Mock
    private AmountsCalculationService amountsCalculationService;
    @Mock
    private ResidualCalculationService residualCalculationService;
    @Mock
    private ReferenceCalculationService referenceCalculationService;
    @Mock
    private OverpaymentCalculationService overpaymentCalculationService;


    @Test
    void thatInstallmentsAreCalculatedCorrectly() {
        //given
        final var inputData = TestDataFixtures.someInputData();
        final var expected = IntStream.rangeClosed(1, 180).boxed().map(this::createInstallment).toList();

        Mockito.when(timePointCalculationService.calculate(any(BigDecimal.class), any(InputData.class)))
                .thenReturn(TestDataFixtures.someTimePoint());
        Mockito.when(timePointCalculationService.calculate(any(BigDecimal.class), any(Installment.class)))
                .thenReturn(TestDataFixtures.someTimePoint());
        Mockito.when(amountsCalculationService.calculate(any(InputData.class), any(Overpayment.class)))
                .thenReturn(TestDataFixtures.someInstallmentAmounts());
        Mockito.when(amountsCalculationService.calculate(any(InputData.class), any(Overpayment.class), any(Installment.class)))
                .thenReturn(TestDataFixtures.someInstallmentAmounts());
        Mockito.when(residualCalculationService.calculate(any(InstallmentAmounts.class), any(InputData.class)))
                .thenReturn(TestDataFixtures.someMortgageResidual());
        Mockito.when(residualCalculationService.calculate(any(InstallmentAmounts.class), any(InputData.class), any(Installment.class)))
                .thenReturn(TestDataFixtures.someMortgageResidual());
        Mockito.when(referenceCalculationService.calculate(any(InstallmentAmounts.class), any(InputData.class)))
                .thenReturn(TestDataFixtures.someMortgageReference());
        Mockito.when(referenceCalculationService.calculate(any(InstallmentAmounts.class), any(InputData.class), any(Installment.class)))
                .thenReturn(TestDataFixtures.someMortgageReference());
        Mockito.when(overpaymentCalculationService.calculate(any(BigDecimal.class), any(InputData.class)))
                .thenReturn(TestDataFixtures.someOverpayment());

        //when
        final var result = installmentCalculationService.calculate(inputData);
        //then
        Assertions.assertEquals(expected, result);

    }

    private Installment createInstallment(Integer index) {
        return TestDataFixtures.someInstallment()
                .withInstallmentNumber(BigDecimal.valueOf(index));
    }

}