package pl.zajavka.mortgage.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zajavka.mortgage.fixtures.TestDataFixtures;
import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Installment;
import pl.zajavka.mortgage.model.Overpayment;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class DecreasingAmountsCalculationServiceImplTest {

    @InjectMocks
    private DecreasingAmountsCalculationServiceImpl decreasingAmountsCalculationService;

    @Test
    void shouldCalculateFirstDecreasingInstallmentCorrectly() {
        //given
        InputData inputData = TestDataFixtures.someInputData();
        var expected = TestDataFixtures.someInstallmentAmounts()
                .withInstallmentAmount(new BigDecimal("1844.99"))
                .withCapitalAmount(new BigDecimal("1101.49"));
        //when
        var result = decreasingAmountsCalculationService.calculate(inputData, null);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldCalculateOtherDecreasingInstallmentCorrectly() {
        //given
        InputData inputData = TestDataFixtures.someInputData();
        Installment prevoiusInstallment = TestDataFixtures.someInstallment();
        var expected = TestDataFixtures.someInstallmentAmounts()
                .withInstallmentAmount(new BigDecimal("5318.12"))
                .withInterestAmount(new BigDecimal("2483.87"))
                .withCapitalAmount(new BigDecimal("2834.25"));
        //when
        var result = decreasingAmountsCalculationService.calculate(inputData, null, prevoiusInstallment);
        //then
        Assertions.assertEquals(expected, result);
    }

}