package Zajavka.Project_calc.service;

import Zajavka.Project_calc.Model.Rate;
import Zajavka.Project_calc.Model.Summary;

import java.util.List;

public interface SummaryService {

    Summary calculate(List<Rate> rates);
}
