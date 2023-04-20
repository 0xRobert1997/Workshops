package pl.zajavka.mortgage.services;

import pl.zajavka.mortgage.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestData {
    static TimePoint someTimePoint() {
        return TimePoint.builder()
                .year(BigDecimal.valueOf(1))
                .month(BigDecimal.valueOf(1))
                .date(LocalDate.of(2010, 5, 10))
                .build();
    }

    static Rate someRate() {
        return Rate.builder()
                .timePoint(someTimePoint())
                .mortgageResidual(someMortgageResidual())
                .mortgageReference(someMortgageReference())
                .build();
    }

    private static MortgageReference someMortgageReference() {
        return MortgageReference.builder()
                .referenceAmount(BigDecimal.valueOf(666))
                .referenceDuration(BigDecimal.valueOf(420))
                .build();
    }

    private static MortgageResidual someMortgageResidual() {
        return MortgageResidual.builder()
                .residualAmount(BigDecimal.valueOf(666.69))
                .residualDuration(BigDecimal.valueOf(16))
                .build();
    }

    static InputData someInputData() {
        return InputData.builder()
                .repaymentStartDate(LocalDate.of(2010, 5, 10))
                .wiborPercent(BigDecimal.valueOf(2.70))
                .amount(BigDecimal.valueOf(301953.46))
                .monthsDuration(BigDecimal.valueOf(180))
                .rateType(MortgageType.CONSTANT)
                .marginPercent(BigDecimal.valueOf(1.8))
                .overpaymentProvisionPercent(BigDecimal.valueOf(3))
                .overpaymentProvisionMonths(BigDecimal.valueOf(36))
                .overpaymentStartMonth(BigDecimal.valueOf(1))
                .overpaymentReduceWay(Overpayment.REDUCE_PERIOD)
                .mortgagePrintPayoffsSchedule(true)
                .mortgageRateNumberToPrint(1)
                .build();
    }

    static RateAmounts someRateAmounts() {
        return RateAmounts.builder()
                .rateAmount(new BigDecimal("2309.92"))
                .interestAmount(new BigDecimal("1132.33"))
                .capitalAmount(new BigDecimal("1177.59"))
                .build();
    }
}
