package Workshops.no3_localization_and_files.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ex5 {
    public static void main(String[] args) throws IOException {
        Path myPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises/nested1/lorem.txt");

        printSpecificWords(myPath);
    }

    private static void printSpecificWords(Path myPath) throws IOException {
        TreeMap<Integer, List<String>> collect = Files.lines(myPath)
                .map(line -> line.replace(".", "").replace(",", ""))
                .flatMap(line -> Stream.of(line.split(" ")))
                .collect(Collectors.groupingBy(word -> word.length(), TreeMap::new, Collectors.toList()));


        Integer max = collect.keySet().stream().max(Comparator.naturalOrder()).orElseGet(() -> Integer.valueOf(1));


        System.out.println("Second longest: " + collect.get(max).get(1));
        System.out.println("Second 3-letter word: " + collect.get(3).get(1));
    }
}
