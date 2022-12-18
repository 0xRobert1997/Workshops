package Workshops.no2_functional_programming.Streams.ExercisesStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ex2 {

    public static void main(String[] args) {

        String[] letters = {"z", "x", "a", "j", "a", "v", "x", "k", "a", "x"};

        Comparator<String> myComparator = Comparator.naturalOrder();
        System.out.println(Arrays.stream(letters)
                .map(a -> a.toUpperCase())
                .filter(a -> !a.contains("X"))
                .sorted(myComparator.reversed())
                .collect(Collectors.joining("")));


    }
}
