package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {

        // zwraca nie zmienione to co przyjął
        UnaryOperator<String> unaryOperator = str -> str + str;
        System.out.println(unaryOperator.apply("zajavka!"));
    }
}
