package Workshops.no2_functional_programming.ExercisesStreams.project.Source;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal value;
    private final Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    // konstruktory, gettery itp
    public enum Currency {
        PLN,
        EUR
    }
}
