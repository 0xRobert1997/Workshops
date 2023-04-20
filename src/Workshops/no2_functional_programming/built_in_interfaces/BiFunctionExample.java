package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {
        // pierwsze dwa generyki to przyjmowane, ostatni zwracany
        // R apply(T t, U u);
        BiFunction<Table, Window, String> function = (a, b) -> a.toString();
    }

    static class Table {

    }

    static class Window {

    }
}
