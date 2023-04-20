package Workshops.no3_localization_and_files.NIO2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class paths2 {

    public static void main(String[] args) {
        Path path1 = Paths.get("OneDirectory/Workshops/myFile.txt");
        Path path2 = Paths.get("TwoDirectory/Workshops/myFile2.txt");

        System.out.println(path1.toString());
        System.out.println(path1.getNameCount()); // liczy ilość elementów w ścieżce
        System.out.println(path1.getName(1)); // nazwa elementu o podanym indeksie w ścieżce liczony od 0
        System.out.println(path1.getFileName()); // nazwa ostatniego elementu
        System.out.println(path1.toAbsolutePath()); // jeśli podany relative path to metoda rozwiją ścieżkę względem working directory
        System.out.println(path1.isAbsolute());
        System.out.println(path1.toAbsolutePath().getParent());
        System.out.println(path1.getRoot());  // przy ścieżkach relatywnych root jest null'em
        System.out.println(path1.subpath(0, 2)); // przyjmuje start i ilość elementów
        System.out.println(path1.relativize(path2)); // wynikiem jest zestaw kroków które trzeba wykonać żeby przejść z ścieżki1 do drugiej
        System.out.println(path1.resolve(path2)); // skleja 2 ścieżki (jeśli druga ścieżka będzie absolutna to wynikiem będzie po prosta ta ścieżka bez doklejania)
        System.out.println(path1.normalize()); // jesli na ścieżce będą .. to wynikiem będzie prosta ścieżka bez wychodzenia i wchodzenia ponownego


        // sprawdza czy ścieżka faktycznie istnieje na dysku
        try {
            System.out.println(Paths.get(".").toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
