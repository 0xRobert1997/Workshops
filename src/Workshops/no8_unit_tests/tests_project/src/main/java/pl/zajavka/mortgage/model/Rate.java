package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor
@With
public class Rate {

    BigDecimal rateNumber;
    TimePoint timePoint;
    RateAmounts rateAmounts;
    MortgageResidual mortgageResidual;
    MortgageReference mortgageReference;

}
