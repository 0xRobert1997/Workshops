package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        // przyjmuje 2 arg, nic nie zwraca
        BiConsumer<String, Cat> biConsumer1 = (a, b) -> System.out.println("a " + a + "b " + b);
    }

    static class Cat {

    }
}
