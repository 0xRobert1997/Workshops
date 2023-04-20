package Workshops.no3_localization_and_files.Exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex1 {

    public static void main(String[] args) {

        Path myPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises");
        File dir = new File("./src/Workshops/no3_localization_and_files/Exercises");


/*
        try {
            Files.list(myPath)
                    .map(e -> e.toFile())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        listAllFiles(dir);
        System.out.println();
*/

        try {
            Files.walk(myPath)
                    .filter(elem -> Files.isRegularFile(elem))
                    .map(elem -> elem.getFileName())
                    .filter(elem -> elem.toString().endsWith(".jpg"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void listAllFiles(File dir) {
        File[] files = dir.listFiles();

        for(File file: files) {
            if (file.isDirectory()) {
                listAllFiles(file);
            } else {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }
}
