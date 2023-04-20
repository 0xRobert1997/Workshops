package Workshops.no2_functional_programming.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class streamCollectorsV1 {
    // counting
    // joining
    // toCollection
    // maxBy | minBy
    // mapping

    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Warszawa","Lublin", "Gdańsk", "Łódź", "Wrocław", "Gdańsk");

        // counting
        // po prostu liczy ilość elementów
        long countResult = cities.stream()
                .collect(Collectors.counting());

        // joining
        // można wpisać 'oddzielacz' oraz coś co ma być wydrukowane na początku i na końcu
        // może być używany tylko do klas które implementują CharSequence, najczęściej String
        cities.stream()
                .filter(a -> a.length() > 6)
                .collect(Collectors.joining(", ", "start: ", " :koniec"));


        // toCollection
        // toList, toSet (wg dokumentacji nie wiadomo jaką implementację listy/setu zwróci)
        // można dać var jako typ zmiennej żeby nie trzeba było zmieniać

        // można wymusić daną implementację:
        //  .collect(Collectors.toCollection( () -> new TreeSet<>()));

        var collect = cities.stream()
                .filter(a -> a.length() > 6)
                .collect(Collectors.toList());


        // maxBy | minBy
        // wymaga comparator'a
        // zwraca Optional'a
        Comparator<String> myComparator = Comparator.naturalOrder();

        Optional<String> collect2 = cities.stream()
                .collect(Collectors.minBy(myComparator.reversed()));


        // mapping
        // przyjmuje Function i jakiś Collector

        // tak normalnie
        cities.stream()
                .map(String::length)
                .reduce(0, (a, b) -> a +b);
        // tak z maping
        cities.stream()
                .collect(Collectors.mapping(String::length, Collectors.reducing(0, (a, b) -> a +b)));
    }
}
