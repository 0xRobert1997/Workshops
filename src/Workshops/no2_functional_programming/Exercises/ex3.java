package Workshops.no2_functional_programming.Exercises;

import java.util.Optional;
import java.util.function.BinaryOperator;

public class ex3 {

    public static void main(String[] args) {

        BinaryOperator<Car> myBinaryOperator = (a, b) -> {
            if (a.compareTo(b) > 0) {
                return a;
            } else if (a.compareTo(b) < 0) {
                return b;
            } else {
                return null;
            }
        };

        Car resultBinary = myBinaryOperator.apply(new Car("xx"), new Car("yyyyyy"));

        Car carOpt = Optional
                .ofNullable(resultBinary)
                .orElseThrow( () -> {
                    throw new RuntimeException("ojojoj");
                } );


    }


    static class Car implements Comparable<Car>{
        private final String model;

        public Car(String model) {
            this.model = model;
        }

        public String getModel() {
            return model;
        }

        @Override
        public int compareTo(Car o) {
            return this.model.length() - o.model.length();
        }
    }
}
