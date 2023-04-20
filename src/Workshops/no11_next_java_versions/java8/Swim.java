package Workshops.no11_next_java_versions.java8;


// metody defaulotwe i statyczne nie przeszkadzają w tym żeby oznaczyć interface jako funkcyjny
@FunctionalInterface
public interface Swim {

   // public abstract String canSwim();

    // dodano defaulotwe i statyczne metody w interface

    default String canSwim() {
        return  "Nope";
    }

    // statyczną metodę z interface'u można wywołać tylko na tym interface, nie można wywołać ani na klasie implementującej
    // ten interface ani na obiekcie tej klasy

    static void someMethod() {
        System.out.println("Calling static method");
    }

    String someMethodToImplementByLambda();
}
