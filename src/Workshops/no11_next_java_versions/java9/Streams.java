package Workshops.no11_next_java_versions.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        // ordered
        // unordered

        // takeWhile() bierze elementy do momentu gdy pojawi sie pierszy element który nie spełnia warunku
        // jak damy e > 5 to pierwszy element już nie spełnia dlatego zwraca pusty stream


        List<Integer> collect1 = List.of(1, 3, 5, 7, 10, 12, 13, 15)
                .stream()
                .takeWhile(e -> e > 5)
                .collect(Collectors.toList());
        System.out.println(collect1);


        // dropWhile()
        // dropuje - wywala elementy dopóki predykat jest spełniony

        List<Integer> collect2 = List.of(1, 3, 5, 7, 10, 12, 13, 15)
                .stream()
                .dropWhile(e -> e < 5)
                .collect(Collectors.toList());
        System.out.println(collect2);


        // Iterate
        System.out.println("#1");
        IntStream.iterate(2, e -> e * e)
                .limit(4)
                .forEach(System.out::println);


        System.out.println("#2");
        IntStream.iterate(2, e -> e < 256, e -> e * e)
                .forEach(System.out::println);

        // nullable
        System.out.println(Stream.ofNullable(null).count());
        System.out.println(Stream.ofNullable(1).count());

        SomeAbstractClass<String> someAbstractClass = new SomeAbstractClass<String>() {
            @Override
            void call(String p1, String p2) {
                System.out.println("Running" + p1 + ", " + p2 );
            }
        };
        someAbstractClass.call("1", "2");



        // Java modules


    }




}
