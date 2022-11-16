package Zajavka.Project_calc.service;

import Zajavka.Project_calc.Model.InputData;
import Zajavka.Project_calc.Model.TimePoint;

import java.math.BigDecimal;

public interface TimePointService {



    TimePoint calculate(BigDecimal rateNumber, InputData inputData);
}
