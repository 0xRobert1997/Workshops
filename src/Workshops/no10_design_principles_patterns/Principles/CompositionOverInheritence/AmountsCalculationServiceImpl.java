package Workshops.no10_design_principles_patterns.CompositionOverInheritence;


public class AmountsCalculationServiceImpl implements AmountsCalculationService{
    private final ConstantAmountsCalculationService constantAmountsCalculationService;
    private final DecreasingAmountCalculationService decreasingAmountCalculationService;

    public AmountsCalculationServiceImpl(
            ConstantAmountsCalculationService constantAmountsCalculationService,
            DecreasingAmountCalculationService decreasingAmountCalculationService
    ) {
        this.constantAmountsCalculationService = constantAmountsCalculationService;
        this.decreasingAmountCalculationService = decreasingAmountCalculationService;
    }
}
