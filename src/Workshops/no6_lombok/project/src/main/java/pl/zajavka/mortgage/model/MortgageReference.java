package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class MortgageReference {

    private final BigDecimal referenceAmount;

    private final BigDecimal referenceDuration;


}
