package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.ex1;

import java.math.BigDecimal;

public class Invoice {
    private final String id;
    private final BigDecimal amount;

    public Invoice(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}

