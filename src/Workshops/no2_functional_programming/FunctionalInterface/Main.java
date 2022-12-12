package Workshops.no2_functional_programming.FunctionalInterface;

public class Main {

    public static void main(String[] args) {
        SomeFunctionalInterface myImpl = a -> System.out.println("calling func interface" + a);

        myImpl.consume("myArgument");
        myImpl.someDefault();
        SomeFunctionalInterface.someStatic();

    }
}
