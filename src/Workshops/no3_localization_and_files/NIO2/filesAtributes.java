package Workshops.no3_localization_and_files.NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class files3 {

    public static void main(String[] args) {
        Path path = Paths.get("src/Workshops/myFile.txt");


        // zwraca rozmiar pliku w bajtach, warto pamiętać że polskie znaki ą,ę,ł itd. są zapisywane na 2B
        try {
            System.out.println(Files.size(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
