package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class Summary {

    private final BigDecimal interestSum;
    private final BigDecimal overpaymentProvisionSum;
    private final BigDecimal totalLostSum;
    private final BigDecimal totalCapital;



}
