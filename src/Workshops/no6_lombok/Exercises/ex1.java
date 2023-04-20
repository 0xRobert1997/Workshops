package Workshops.no6_lombok.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ex1 {

    public static void filesSize(Path path){
        try {
            System.out.println(Files.size(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
