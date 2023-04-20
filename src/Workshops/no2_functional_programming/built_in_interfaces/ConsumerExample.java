package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        // coś bierze a nic nie zwraca
        Consumer<String> consumer1 = input -> System.out.println(input);
        Consumer<String> consumer2 = System.out::println;

        consumer1.accept("to consume");
    }
}
