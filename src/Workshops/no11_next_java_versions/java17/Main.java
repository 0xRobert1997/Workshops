package Workshops.no11_next_java_versions.java17;

public class Main {
    // sealded classes
    // klasy które dostają permita i dziedziczą z klasy sealed musz być sealed/non-sealed albo final

    // Pattern matching for switch - preview

    public static void main(String[] args) {

        method(new Monkey());

    }

    private static void method(SealedAnimal animal) {
        /*switch (animal) {
            case Cat cat -> System.out.println("it's cat");
            case Dog dog -> System.out.println("it's dogo");
            case Monkey monkey -> System.out.println("it's monkey");
            case null, default -> System.out.println("idk what's this");
        }*/
    }
}
