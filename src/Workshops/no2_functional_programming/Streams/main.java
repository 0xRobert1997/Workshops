package Workshops.no2_functional_programming.Streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

    public static void main(String[] args) {

        List<String> myList1 = List.of("Opole", "Gdynia", "Szczecin");
        List<String> myList2 = List.of("Wrocław", "Zakowapen", "Szczecin" );
        List<String> myList3 = List.of("Opole", "Biały", "Poznan");

        List<Dog> dogList = List.of(new Dog("a"), new Dog("c"), new Dog("b"));

        System.out.println(List.of(myList1, myList2, myList3).stream()
                .flatMap(e -> e.stream())
                .map(e -> e + "e")
                .distinct()
                .limit(3)
                .collect(Collectors.joining(";")));


    }
    static class Dog  {
        private String name;
        public Dog(final String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }

    }

}
