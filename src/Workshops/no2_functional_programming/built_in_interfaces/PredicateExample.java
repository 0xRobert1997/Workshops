package Workshops.no2_functional_programming.built_in_interfaces;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        // przyjmuje 1 arg, zwraca boolean

        List<String> cities = new ArrayList<>();
        cities.add("Szczecin");
        cities.add("Gdynia");
        cities.add("Zakopane");

        print(cities, a -> a.contains("z"));

        print(cities, PredicateExample::stringTest);


    }

    private static boolean stringTest(String input) {
        System.out.println("Calling check for city: " + input);
        return input.contains("i");
    }

    private static void print(final List<String> cities, Predicate<String> checker) {
        for (String city : cities) {
            if (checker.test(city)){
                System.out.println(city);
            }
        }

    }
}
