package Zajavka.Project_calc;

import Zajavka.Project_calc.Model.InputData;
import Zajavka.Project_calc.Model.Overpayment;
import Zajavka.Project_calc.Model.MortgageType;
import Zajavka.Project_calc.service.*;

import java.math.BigDecimal;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {

        InputData inputData = new InputData()
                .withAmount(new BigDecimal("300000"))
                .withOverpaymentSchema(Collections.emptyMap())
                .withMonthsDuration(new BigDecimal(360))
                .withRateType(MortgageType.CONSTANT)
                .withOverpaymentReduceWay(Overpayment.REDUCE_RATE);


        PrintingService printingService = new PrintingServiceImpl();

        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(
                        new ConstantAmountsCalculationServiceImpl(),
                        new DecreasingAmountsCalculationServiceImpl()
                ),
                new OverpaymentCalculationServiceImpl(),
                new ResidualCalculationServiceImpl(),
                new ReferenceCalculationServiceImpl()
        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService,
                SummaryServiceFactory.create()
                );

        mortgageCalculationService.calculate(inputData);








    }
}
