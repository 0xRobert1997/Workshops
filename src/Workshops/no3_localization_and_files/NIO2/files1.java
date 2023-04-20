package Workshops.no3_localization_and_files.NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class files1 {

    public static void main(String[] args) {

        Path path1 = Paths.get("src/workshops/myFile.txt");
        Path path2 = Paths.get("src/workshops/myFileCopied.txt");

        System.out.println(Files.exists(path1));

        try {
            System.out.println(Files.createDirectory(path1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.delete(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.deleteIfExists(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(Files.copy(path1, path2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(Files.move(path1, path2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(Files.readAllLines(path1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
