package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.BinaryOperator;

public class BinarOperatorExample {

    public static void main(String[] args) {

        BinaryOperator<String> binaryOperator = (s, str) -> s.concat(str);
    }
}
