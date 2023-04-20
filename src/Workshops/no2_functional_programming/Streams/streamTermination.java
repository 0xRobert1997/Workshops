package Workshops.no2_functional_programming.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamTermination {
        // count
        // findFirst | findAny              - zwracją Optional
        // min max                          - przyjmują Comparator (nawet jeśli porównywane objekty implementują comparable)
        // allMatch | anyMatch | noneMatch  - zwraca Boolean, przyjmuje Predicate
        // forEach                          - przyjmuje Consumer'a i wywoluje go na kazdym elemencie jak w petli
        //                                      (consumer zwraca void'a także wynikiem forEach'a też będzie void)
        // reduce                           - przyjmuje
        //                                 (opcjonalnie wartość początkową T), (opcjonalnie biFunction) i binaryOperator
        //                                  jeśli nie podamy wartości początkowej to zwraca Optional'a
        // collect
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("v1");
        myList.add("v2");
        String[] myTable = new String[] {"x", "y", "z"};

        List<String> result = myList.stream()
                .peek(a -> System.out.println("value: " + a))
                .collect(Collectors.toList());

        result.stream()
                .peek(a -> System.out.println("value: " + a))
                .collect(Collectors.toList());



        List<String> collect1 = Stream.of(myTable)
                .collect(Collectors.toList());

           /* nie zadziała
        List<String> collect2 = Stream.of(myList)
                .collect(Collectors.toList());*/

        List<String> collect2 = myList.stream()
                .collect(Collectors.toList());


        Set<String> collect3 = Stream.of(myTable)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));


    }
}
