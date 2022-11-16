package Zajavka.Exceptions_PodsumowanieTygodnia.Checked;

public class Main {

    public static void main(String[] args) {
        try {
            runAgeChecker();
        } catch (MyCheckedException e) {
            System.out.println("Handling exception somehow " + e.getMessage());

        }
        System.out.println("xD");


    }
    private static void runAgeChecker() throws MyCheckedException {
        ageChecker(12);
    }
    private static void ageChecker(int age) throws MyCheckedException {
        if (age > 20) {
            System.out.println("OK");
        } else {
            throw new MyCheckedException("Sorry, ale jesteś za młody");
        }
    }
}
