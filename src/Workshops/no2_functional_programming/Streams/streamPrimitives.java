package Workshops.no2_functional_programming.Streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.*;

public class streamPrimitives {

    // IntStream
    // LongStream
    // DoubleStream
    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1,2,3);

        DoubleStream.generate(() -> Math.random())
                .limit(4)
                .forEach(System.out::println);

        System.out.println("####");

        // tylko IntStream i LongStream:
        // range()
        // rangeCLose() - generuje do podanej wartości - 1

        LongStream.range(20, 30)
                .forEach(System.out::println);

        // mają swoje Optional'e
        OptionalDouble max = DoubleStream.empty().max();

        // boxed()
        // pozwala przejść z IntStream na Stream<Integer>
        IntStream intStream2 = IntStream.of(1, 2, 3);
        Stream<Integer> boxed = intStream.boxed();
        List<Integer> collected = boxed.collect(Collectors.toList());
    }
}
