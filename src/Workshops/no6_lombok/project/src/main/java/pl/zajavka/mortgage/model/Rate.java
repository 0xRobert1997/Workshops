package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class Rate {

    private final BigDecimal rateNumber;

    private final TimePoint timePoint;

    private final RateAmounts rateAmounts;

    private final MortgageResidual mortgageResidual;

    private final MortgageReference mortgageReference;



}
