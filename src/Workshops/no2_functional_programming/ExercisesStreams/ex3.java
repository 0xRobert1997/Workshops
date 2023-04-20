package Workshops.no2_functional_programming.ExercisesStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ex3 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 5, 16, 18, 2, 5, 2, 6, 2, 1, 6, 1, 23, 64, 34);

        Optional<Integer> first = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .skip(1)
                .findFirst();

       first.ifPresent(System.out::println);

    }
}
