package pl.zajavka.mortgage.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Rate;
import pl.zajavka.mortgage.model.RateAmounts;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static pl.zajavka.mortgage.services.TestData.someRate;

class ConstantAmountsCalculationServiceImplTest {

    private ConstantAmountsCalculationService constantAmountsCalculationService;

    @BeforeEach
    public void setup() {
        this.constantAmountsCalculationService = new ConstantAmountsCalculationServiceImpl();
    }

    @Test
    @DisplayName("Calculate rate amounts for first rate")
    void shouldCalculateFirstRateAmountsCorrectly() {
        //given
        InputData inputData = TestData.someInputData();
        RateAmounts expected = TestData.someRateAmounts();

        //when
        RateAmounts result = constantAmountsCalculationService.calculate(inputData, null);

        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Calculate rate amounts for other rates")
    void shouldCalculateOtherRateAmountsCorrectly() {
        //given
        InputData inputData = TestData.someInputData();
        RateAmounts expected = TestData.someRateAmounts()
                .withRateAmount(new BigDecimal("3.15"))
                .withInterestAmount(new BigDecimal("2.50"))
                .withCapitalAmount(new BigDecimal("0.65"));
        Rate rate = someRate();

        //when
        RateAmounts result = constantAmountsCalculationService.calculate(inputData, null, rate);

        //then
        Assertions.assertEquals(expected, result);

    }
}