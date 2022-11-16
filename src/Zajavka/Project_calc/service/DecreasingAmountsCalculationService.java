package Zajavka.Project_calc.service;

import Zajavka.Project_calc.Model.InputData;
import Zajavka.Project_calc.Model.Overpayment;
import Zajavka.Project_calc.Model.Rate;
import Zajavka.Project_calc.Model.RateAmounts;

public interface DecreasingAmountsCalculationService {


    RateAmounts calculate(InputData inputData, Overpayment overpayment);

    RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
