package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class RateAmounts {

    private final BigDecimal rateAmount;

    private final BigDecimal interestAmount;

    private final BigDecimal capitalAmount;

    private final Overpayment overpayment;



}
