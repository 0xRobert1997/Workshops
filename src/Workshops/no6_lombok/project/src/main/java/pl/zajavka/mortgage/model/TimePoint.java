package pl.zajavka.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class TimePoint {

    private final BigDecimal year;

    private final BigDecimal month;

    private final LocalDate date;


}
