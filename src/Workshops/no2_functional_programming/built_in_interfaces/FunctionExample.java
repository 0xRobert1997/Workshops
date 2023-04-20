package Workshops.no2_functional_programming.built_in_interfaces;

import java.util.Optional;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        // przyjmuje 1 argument
        // ma dwa generyki, pierwszy to co ma wejść, drugi to co ma zwrócić
        // R apply(T t);

        Function<Car, String> carStringFunction = Car::toString;
        Optional<String> carOpt = Optional.of(new Car())
                .map(carStringFunction);

        Function<Car, String> functionImpl = c -> {
            System.out.println(c);
            return "someString";
        };

        functionImpl.apply(new Car());

    }

    static class Car {

    }
}
