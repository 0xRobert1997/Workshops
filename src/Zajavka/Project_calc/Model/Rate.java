package Zajavka.Project_calc.Model;

import java.math.BigDecimal;

public class Rate {

    private final BigDecimal rateNumber;

    private final TimePoint timepoint;

    private final RateAmounts rateAmounts;

    private final MortgageResidual mortgageResidual;

    private final MortgageReference mortgageReference;

    public Rate(
            BigDecimal rateNumber,
            TimePoint timepoint,
            RateAmounts rateAmounts,
            MortgageResidual mortgageResidual,
            MortgageReference mortgageReference
    ) {
        this.rateNumber = rateNumber;
        this.timepoint = timepoint;
        this.rateAmounts = rateAmounts;
        this.mortgageResidual = mortgageResidual;
        this.mortgageReference = mortgageReference;
    }

    public BigDecimal getRateNumber() {
        return rateNumber;
    }

    public TimePoint getTimepoint() {
        return timepoint;
    }

    public RateAmounts getRateAmounts() {
        return rateAmounts;
    }

    public MortgageResidual getMortgageResidual() {
        return mortgageResidual;
    }

    public MortgageReference getMortgageReference() {
        return mortgageReference;
    }
}
