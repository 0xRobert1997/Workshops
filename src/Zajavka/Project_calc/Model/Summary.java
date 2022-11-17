package Zajavka.Project_calc.Model;

import java.math.BigDecimal;

public class Summary {

    private final BigDecimal interestSum;

    private final BigDecimal overpaymentProvisions;

    private final BigDecimal totalLostSum;

    public Summary(BigDecimal interestSum, BigDecimal overpaymentProvisions, BigDecimal totalLostSum) {
        this.interestSum = interestSum;
        this.overpaymentProvisions = overpaymentProvisions;
        this.totalLostSum = totalLostSum;
    }

    public BigDecimal getInterestSum() {
        return interestSum;
    }

    public BigDecimal getOverpaymentProvisions() {
        return overpaymentProvisions;
    }

    public BigDecimal getTotalLostSum() {
        return totalLostSum;
    }
}
