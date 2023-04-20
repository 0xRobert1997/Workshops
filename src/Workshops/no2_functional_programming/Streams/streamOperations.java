package Workshops.no2_functional_programming.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamOperations {

    // podczas debugowania streamu po prawej od ikonek "step over" itd. jest dostępna ikonka Trace Current Stream Chain

                // przyjmuje:
    // filter       - Predicate
    // map          - Function
    // flatMap      - Function
    // peek         - Consumer
    // distinct     - nic nie przyjmuje, odsiewa duplikaty (objekty muszą mieć equals()
    // limit        - long
    // skip         - long
    // sorted       - Comparator albo nic


    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Kazik", new City("Warszawa")),
                new Person("Waldek", new City("Wrocław")),
                new Person("Damian", new City("Zakopane")),
                new Person("Seba", new City("Warszawa")),
                new Person("Mati", new City("Gdynia"))
                );

        Stream<Person> myStream = people.stream();

        // filter
        Stream<Person> filterResult = myStream
                .filter(person -> person.getCity().getCityName().contains("W")
                );


        // map
        // przyjmuje interface Function
        // musi zwrócic coś co da stream
        // jak w Intelij włączony InlayHints to pokazuje po każdej metodzie .map jaki stream z niej wyjdzie
        List<Integer> collect = people.stream()
                .map(person -> person + "A")
                .map(String::toUpperCase)
                .map(s -> s.length())
                .collect(Collectors.toList());


        int counter1 = 0;
        // żeby w streamie móc dodać counter trzeba go zamienić na atomicInteger (bo zmienna musi byc effectivly final
        AtomicInteger counter2 = new AtomicInteger(0);
        // i wtedy w danej lambdzie można dodać
        counter2.incrementAndGet();

        Integer collect2 = people.stream()
                .map(person -> person + "A")
                .map(String::length)
                .reduce(0, Integer::sum);


        // flatMap
        // przyjmuje interface Function
        // przy optionalach w mieliśmy Optional'a w Optional'u to flatMap raz go odwijało

        List<String> cities1 = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Gdańsk");
        List<String> cities2 = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Gdańsk");
        List<String> cities3 = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Gdańsk");

        List<List<String>> citiesCombined = List.of(cities1, cities2, cities3);

        // flatMap spłasza strukture, tzn wychodzi z jednego zagnieżdżenia
        List<String> stringStream = citiesCombined.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());



        // peek
        // przyjmuje Consumer'a

        Set<City> collect1 = people.stream()
                .peek(a -> System.out.println("Step1: " + a))
                .map(person -> person.getCity())
                .peek(a -> System.out.println("Step2: " + a))
                .collect(Collectors.toSet());


        // distinct
        // nic nie przyjmuje, odsiewa duplikaty
        // jeśli jest stream customowych objektów to muszą mieć equals() i hascode()

        String collect3 = cities1.stream()
                .distinct()
                .collect(Collectors.joining(", "));


        // limit
        // ogranicza ilość elementów które są procesowane w streamie
        // jak damy 3 to limituje do 3 elementów a nie do 3 indeksu
        // nie ma znaczenia w którym miejscu w streamie postawimy limit

        cities1.stream()
                .peek(elem -> System.out.println("Step1: " + elem ))
                .limit(3)
                .collect(Collectors.joining(", "));


        // skip
        // jak dajemy skip(3) to znaczy że pierwsze 3 elementy które dotrą do metody skip nie przechodzą do kolejnych
        // więc step2 będzie wykonany tylko dla elementów 4,5,6...
        // zeskipowane elementy nie będą znajdować się w końcowej kolekcji po Collect(...)


        String stringCities = cities1.stream()
                .peek(elem -> System.out.println("Step1: " + elem ))
                .skip(3)
                .peek(elem -> System.out.println("Step2: " + elem ))
                .collect(Collectors.joining(", "));



        // sorted
        // może nic nie przyjmowac, lub przyjąć comparator
        // najpierw wszystkie elementy dojdą do Step1 później zostaną posortowane i dopiero wtedy każdy elementy przejdzie do Step2 już w kolejności posortowanej
        // żeby można było posortować to trzeba mieć wszystkie elementy dlatego przy streamie nieskończonym jeśli damy sorted() przed limit() to nigdy
        // nie zbierze wszystkich elementów do posortowania i będzie się kręcił w nieskończoność

        cities1.stream()
                .peek(elem -> System.out.println("Step1: " + elem ))
                .sorted()
                .peek(elem -> System.out.println("Step2: " + elem ))
                .collect(Collectors.joining(", "));

        // sortowanie mapy po values
        // Stream<Map.Entry<K,V>> sorted =
        //    map.entrySet().stream()
        //       .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));









    }

    private static class Person {
        private final String name;
        private final City city;

        public Person(String name, City city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public City getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", city=" + city +
                    '}';
        }
    }

    private static class City {
        private final String cityName;

        public City(String cityName) {
            this.cityName = cityName;
        }

        public String getCityName() {
            return cityName;
        }

        @Override
        public String toString() {
            return "City{" +
                    "cityName='" + cityName + '\'' +
                    '}';
        }
    }
}
