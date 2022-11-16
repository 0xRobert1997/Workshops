package Zajavka.Project_calc.service;

import Zajavka.Project_calc.Model.Rate;

import java.math.BigDecimal;

public interface Function {

    BigDecimal calculate(Rate rate);
}
