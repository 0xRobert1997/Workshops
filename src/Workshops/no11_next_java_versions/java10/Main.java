package Workshops.no11_next_java_versions.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    // var
    // kolekcje - copyOf() / Collectors.toUnmodifiableList()/Set()
    // Optional - orElseThrow()

    public static void main(String[] args) {

        List<String> food = new ArrayList<>();
        food.add("Banana");
        food.add("Apple");
        food.add("Orange");
        System.out.println("Original: " + food);

        List<String> Copied = List.copyOf(food);

        var x = Optional.ofNullable(null)

                .orElseThrow(() -> new RuntimeException("custom message"));

        food.stream().collect(Collectors.toUnmodifiableList());

    }
}
