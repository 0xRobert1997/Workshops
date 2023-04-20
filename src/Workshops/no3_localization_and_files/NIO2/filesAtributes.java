package Workshops.no3_localization_and_files.NIO2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class filesAtributes {

    public static void main(String[] args) {
        Path path = Paths.get("src/Workshops");


        // zwraca rozmiar pliku w bajtach, warto pamiętać że polskie znaki ą,ę,ł itd. są zapisywane na 2B
        try {
            System.out.println(Files.size(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.getLastModifiedTime(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.setLastModifiedTime(path, FileTime.from(1335L, TimeUnit.HOURS));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isReadable(path));

        try {
            System.out.println(Files.isHidden(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            Stream<Path> list = Files.list(path);

            List<Path> absolutes = list
                    .filter(Files::isRegularFile)
                    .map(p -> p.toAbsolutePath())
                    .collect(Collectors.toList());

            absolutes.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
