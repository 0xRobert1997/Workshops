package code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculator {

    public static int add(int left, int right) {
        System.out.println("add");
        log.debug("some debug message");
        log.info("some info message");
        log.warn("some warn message");
        log.error("some error message");
        return left + right;
    }

    // ctrl + shift + t   skrót do robienia klasy z testami

    public static int subtract(int left, int right) {
        System.out.println("subtract");
        return left - right;
    }
    public static int multiply(int left, int right) {
        System.out.println("multiply");
        return left * right;
    }
    public static int divide(int left, int right) {
        System.out.println("divide");
        return left / right;
    }


}
