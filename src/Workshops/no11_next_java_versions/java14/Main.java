package Workshops.no11_next_java_versions.java14;

public class Main {
    // switch - już na stałe
    // NullPointerException - wyrzucana wiadomość dokładniej określa co go spowodowało
    // Pattern Matching instanceof - preview
    // Records - preview
    // Text Blocks- preview
    public static void main(String[] args) {




    }

    private static void newSwitch(String input) {

        // przy nowym switchu zawsze musi być na końcu default
        int result = switch (input) {
            case "A", "B", "C" -> 1;
            case "D", "E", "F" -> 2;
            default -> 0;
        };
        System.out.println("new switch: " + result);

        // yield to taki return dla switcha
        int result2 = switch (input) {
            case "A", "B", "C": yield 1;
            case "D", "E", "F": yield 2;
            default: yield 0;
        };
    }

    private static void oldSwitch(String input) {
        int result = 0;
        switch (input) {
            case "A":
            case "B":
            case "C":
                result = 1;
                break;
            case "D":
            case "E":
            case "F":
                result = 2;
        }
        System.out.println("Old switch: " + result);
    }
}
