package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.BiPredicate;

public class BiPredicateExample {

    public static void main(String[] args) {
        // przyjmuje 2 argumenty, zwraca boolean

        BiPredicate<String, Dog> biPredicate = (a, b) -> b.toString().contains(a);
    }

    static class Dog {

    }
}
