package Workshops.no2_functional_programming.Streams;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamCreation {

    public static void main(String[] args) {

        Stream<String> myEmptyStream = Stream.empty();
        Stream<String> stringStream = Stream.of("1", "2", "3")
                .peek(elem -> System.out.println("elem: " + elem));
        // operacja terminująca, bez niej nie odpali się ^lambda
        // na stremie można wykonać tylko jedną operację terminującą, przy kolejnej próbie wywali wyjątek
        stringStream.collect(Collectors.toList());

        List<String> stringList = List.of("elem1", "elem2", "elem3", "elem4");
        // na podstawie listy można zrobić wiele streamów
        Stream<String> stream1 = stringList.stream();
        Stream<String> stream2 = stringList.stream();
        // operacji pośrednich nie musi mieć, ale terminującą tak
        stream1.collect(Collectors.toList());
        stream2.collect(Collectors.toList());

        // nieskończony stream
        Stream.generate(() -> "someValue")
                .collect(Collectors.toList());

        // żeby zobaczyć stream poniżej trzeba zakomentować ten wyżej bo ten wyżej robi wartości w nieskończoność i ten niżej nigdy się nie odpali
        Stream.iterate(0, a -> a + 1)
                .peek(e -> System.out.println("elem: " + e))
                .collect(Collectors.toList());



        Map<Integer, String> myMap = new HashMap<>();
        Stream<Map> myStream = Stream.of(myMap);

        Stream<Map.Entry<Integer, String>> streem = myMap.entrySet().stream();
    }
}
