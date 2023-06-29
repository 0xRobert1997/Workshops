package code;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {

        Stream<Integer> exampleOfRegularStream = Stream.of(1, 2, 3);
        Stream<Integer> exampleOfParallelStream = exampleOfRegularStream.parallel();
        // lub
        Stream<Integer> anotherExampleOfParallelStream = Arrays.asList(1, 2, 3).parallelStream();
    }
}
