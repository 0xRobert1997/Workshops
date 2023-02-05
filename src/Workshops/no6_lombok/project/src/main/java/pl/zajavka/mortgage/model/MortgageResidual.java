package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class MortgageResidual {

    private final BigDecimal residualAmount;

    private final BigDecimal residualDuration;


}
