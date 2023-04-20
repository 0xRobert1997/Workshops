package Workshops.no2_functional_programming.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class streamCollectorsV2 {

    // toMap
    // partitioningBy
    // groupingBy

    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Warszawa","Lublin", "Gdańsk", "Łódź", "Wrocław", "Gdańsk");


        // toMap
        // przyjmuje Function, Function, Binaryoperator
        // jeśli w wyniku tworzenia mapy wyjdą 2 takie same klucze to wyrzuci wyjątek - wtedy trzeba użyć mergeFunction(BinaryOperator) jako drugiego argumentu
        // przy mergeFunction (v1,v2) -> ### v1 to wynik valueMapper z poprzedniej linijki
        Map<String, Integer> collect1 = cities.stream()
                .collect(Collectors.toMap( key -> key, value -> value.length()));

        // paritioningBy
        // przyjmuje Predicate
        // wynikiem jest mapa z boolean i listy albo mapa z boolean i T
        Map<Boolean, List<String>> collect2 = cities.stream()
                .collect(Collectors.partitioningBy( city -> city.length() > 6));
        // tutaj przy kluczu true będą wszystkie miasta które spełniają dany warunek


        // groupingBy
        // przyjmuje Function + collector albo + supplier i collector
        // też zwraca mape

        Map<Integer, List<String>> collect3 = cities.stream()
                .collect(Collectors.groupingBy(city -> city.length()));


    }
}
