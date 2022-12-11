package Zajavka.Exceptions_PodsumowanieTygodnia.Unchecked;

public class Main {

    public static void main(String[] args) {
        runAgeChecker();
        System.out.println("Ta linijka nigdy się nie wydrukuje");
    }
    private static void runAgeChecker() {
        ageChecker(20);
    }
    private static void ageChecker(int age) {
        if (age > 20) {
            System.out.println("OK");
        } else {
            throw new MyRuntimeException("Sorry, ale jesteś za młody");
        }
    }
}
