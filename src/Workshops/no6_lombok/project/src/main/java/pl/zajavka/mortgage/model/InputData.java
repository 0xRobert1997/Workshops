package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class InputData {

    private static final BigDecimal PERCENT = new BigDecimal("100");

    private LocalDate repaymentStartDate = LocalDate.of(2020, 12, 10);

    private BigDecimal wiborPercent = BigDecimal.valueOf(1.70);

    private BigDecimal amount = BigDecimal.valueOf(301953.46);
    private BigDecimal monthsDuration = BigDecimal.valueOf(180);

    private MortgageType rateType = MortgageType.CONSTANT;

    private BigDecimal marginPercent = BigDecimal.valueOf(1.6);

    private BigDecimal overpaymentProvisionPercent = BigDecimal.valueOf(3);
    private BigDecimal overpaymentProvisionMonths = BigDecimal.valueOf(36);

    private BigDecimal overpaymentStartMonth = BigDecimal.valueOf(1);
    private Map<Integer, BigDecimal> overpaymentSchema = Map.of(
        2, BigDecimal.valueOf(10000),
        3, BigDecimal.valueOf(10000),
        5, BigDecimal.valueOf(10000),
        6, BigDecimal.valueOf(10000),
        7, BigDecimal.valueOf(10000)
    );
    private String overpaymentReduceWay = Overpayment.REDUCE_PERIOD;

    private boolean mortgagePrintPayoffsSchedule = true;
    private Integer mortgageRateNumberToPrint = 1;



    public BigDecimal getInterestPercent() {
        return getMarginPercent().add(getWiborPercent());
    }

    public BigDecimal getInterestToDisplay() {
        return wiborPercent.add(marginPercent);
    }
}
