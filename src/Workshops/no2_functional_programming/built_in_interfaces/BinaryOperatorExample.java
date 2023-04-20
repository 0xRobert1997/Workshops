package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    // 2 parametry wejściowe i parametr wyjściowy są takie same
    public static void main(String[] args) {

        BinaryOperator<String> binaryOperator = (s, str) -> s.concat(str);
    }
}
