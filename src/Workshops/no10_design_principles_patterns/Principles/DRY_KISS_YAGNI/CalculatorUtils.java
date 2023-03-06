package Workshops.no10_design_principles_patterns.DRY_KISS_YAGNI;

public class CalculatorUtils {

    public static final Integer MAX_LIST_SIZE = 1000;

    public static int add(int a, int b) {
        someMethod(1000);
        someMethod(MAX_LIST_SIZE);

        return a+b;
    }

    private static void someMethod(int i) {

    }
}
