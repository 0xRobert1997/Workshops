package Workshops.no3_localization_and_files.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ex2 {
    public static void main(String[] args) {

        Path rootPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises");
        String searchedWord = "zajavka";
        List<String> prohibitedExtensions = List.of(".docx", ".jpg", ".pdf");


        printSpecificPaths(rootPath, searchedWord, prohibitedExtensions);
    }

    private static void printSpecificPaths(Path rootPath, String searchedWord, List<String> prohibitedExtensions) {

        try {
            Files.walk(rootPath)
                    .filter(Files::isRegularFile)
                    .filter(path -> !prohibitedExtensions.contains(getPathExtension(path)))
                    .filter(path -> {
                        try {
                           return Files.lines(path).anyMatch(line -> line.contains(searchedWord));
                        } catch (IOException e) {
                            System.err.println("unable to check file content for: " + path + " and word: " + searchedWord + ". Messegae: " + e.getMessage());
                            return false;
                        }
            })
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPathExtension(Path path) {
        String fileName = path.getFileName().toString();
        int i = fileName.lastIndexOf('.');
        if (i == 1) {
            return path.getFileName().toString();
        }
        return fileName.substring(i);
    }
}
