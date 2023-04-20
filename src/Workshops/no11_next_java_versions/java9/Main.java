package Workshops.no11_next_java_versions.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    // JShell - REPL - read evaluate print loop
    // x2 shift i wyszukać jshell żeby otworzyć w intellij
    // prywatne metody w interface
    // Optionale
    // Streamy
    public static void main(String[] args) {

        // dodane do Optionala or() / stream() / ifPresentOrElse()

        Optional<String> result1=  Optional.<String>ofNullable(null)
                .or( () -> Optional.of("something"));

        var result2=  Optional.<String>ofNullable(null)
                .stream()
                .map(value -> Integer.valueOf(value))
                .collect(Collectors.toList());

        // ifPresentOrElse przyjmuje Consumera i Runnable
        Optional.<String>ofNullable("abc")
                .ifPresentOrElse(v -> System.out.println(v), () -> System.out.println("xd"));


    }


    // IO
    void beforeJava9() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            System.out.println(reader.readLine());
        }
    }
    void afterJava9() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        try (reader) {
            System.out.println(reader.readLine());
        }
    }

}
