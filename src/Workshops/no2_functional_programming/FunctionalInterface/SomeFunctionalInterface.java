package Workshops.no2_functional_programming.FunctionalInterface;

@FunctionalInterface
public interface SomeFunctionalInterface {

    void consume(String arg);

    // metod defaultowych i statycznych może być dużo
    default String someDefault() {
        System.out.println("calling default");
        return "someDefault";
    }

    static String someStatic() {
        System.out.println("calling static");
        return "someStatic";
    }
}
