package Workshops.no3_localization_and_files.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ex7 {

    public static void main(String[] args) throws IOException {

        Path myPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises/nested1/lorem.txt");

        fileWordsCount(myPath);
    }

    private static void fileWordsCount(Path myPath) throws IOException {
        List<String> collect = Files.lines(myPath)
                .map(line -> line.split(" "))
                .flatMap(table -> Stream.of(table))
                .collect(Collectors.toList());


        System.out.println("number of words: : " + collect.size());


        System.out.println(collect);
    }
}
