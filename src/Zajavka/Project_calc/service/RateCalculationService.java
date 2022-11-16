package Zajavka.Project_calc.service;

import Zajavka.Project_calc.Model.InputData;
import Zajavka.Project_calc.Model.Rate;

import java.util.List;

public interface RateCalculationService {

    List<Rate> calculate(final InputData inputData);
}
