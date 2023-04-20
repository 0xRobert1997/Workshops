package Workshops.no3_localization_and_files.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ex6 {

    public static void main(String[] args) throws IOException {

        Path myPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises/nested1/lorem.txt");

        convertTextToUppercase(myPath);
    }

    private static void convertTextToUppercase(Path myPath) throws IOException {
        List<String> collect = Files.lines(myPath)
                .map(line -> line.toUpperCase())
                .collect(Collectors.toList());

        Files.write(myPath, collect);

    }
}
