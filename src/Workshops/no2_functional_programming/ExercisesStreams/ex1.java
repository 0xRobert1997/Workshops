package Workshops.no2_functional_programming.Streams.ExercisesStreams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ex1 {

    static Integer temp = 1;

    public static void main(String[] args) {

        Integer x = 5;
        AtomicInteger temp = new AtomicInteger(1);

        IntStream.rangeClosed(1, x)
                .forEach(a -> System.out.println(IncreaseTemp(a)));

    }

    private static int IncreaseTemp(int i ) {
       return temp = temp * i;
    }
}
