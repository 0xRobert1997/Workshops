package Workshops.no3_localization_and_files.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ex4 {

    public static void main(String[] args) throws IOException {
        Path myPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises");

        printOldestNewest(myPath);

    }

    private static void printOldestNewest(Path myPath) throws IOException {

        List<Path> sorted = Files.walk(myPath)
                .filter(Files::isRegularFile)
                .sorted(Comparator.comparing(path -> {
                    try {
                        return Files.getLastModifiedTime(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return FileTime.fromMillis(0);
                })).toList();

        if (sorted.isEmpty()) {
            System.out.println("Nothing found");
        } else {
            System.out.printf("Oldest: %s, Newest: %s", sorted.get(0), sorted.get(sorted.size() - 1));
        }

    }
}
