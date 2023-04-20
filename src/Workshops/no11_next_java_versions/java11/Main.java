package Workshops.no11_next_java_versions.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.BiFunction;

public class Main {

    // string - isBlank() / lines() / repeat() / strip(), stripLeading(), stripTrailing()
    // strip dziala na wieksze spectrum bialych znakow niz trim()
    // lines zwraca stream stringów
    // vary w lambdach
    // files - writeString() / readString()

    public static void main(String[] args) {

        char char1 = '\u0020';
        char char2 = '\u2000';

        System.out.println(char1);
        System.out.println(char2);

        BiFunction<Integer, String, Boolean> impl = (var e1, var e2) -> (e1.toString() + e2).length() > 2;

        try {
            Files.writeString(Paths.get("zajavka.txt"), "some sentence");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new ArrayList<>(Set.of());
    }
}
