package Workshops.no11_next_java_versions.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    // metody defaulotwe i statyczne w interface'ach
    // datetime
    // całe programowanie funkcyjne, lambdy, streamy itd.
    // optionale
    // IO - operacje na plikach

    public static void main(String[] args) {

        Swim swim = () -> "Something";

        swim.someMethodToImplementByLambda();
        swim.canSwim();
        Swim.someMethod();


        List<Integer> source = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        source.forEach(element -> {
            System.out.println("Calling consumer with element: " + element);
        });

        System.out.println(source);
        source.removeIf(e -> e>3);
        System.out.println("After removeIf: " + source);


        Map<Integer,String> someMap = new HashMap<>();
        someMap.put(1, "1");
        someMap.put(2, "2");
        someMap.put(3, "3");
        someMap.put(4, "4");
        System.out.println(someMap);
        someMap.replaceAll((key, value) -> value + "replaced:k " + key);
    }
}
