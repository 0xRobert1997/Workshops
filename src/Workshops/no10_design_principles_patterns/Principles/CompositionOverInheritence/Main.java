package Workshops.no10_design_principles_patterns.Principles.CompositionOverInheritence;

public class Main {

    public static void main(String[] args) {

        if (true) {
            new AmountsCalculationServiceImpl(new Impl1(), new Impl3());
        } else {
            new AmountsCalculationServiceImpl(new Impl2(), new Impl4());
        }
    }
}
