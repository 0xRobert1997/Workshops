package Workshops.no3_localization_and_files.Exceptions;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AutoCloseable {

    public static void main(String[] args) {

        example(Paths.get("someFile.txt"));
    }

    public static void example(final Path path1) {
        try (Door door = new Door()) {
            System.out.println("Opening door");
        } catch (IOException e) {
            System.out.println("Handling door exepction: " + e.getMessage());
        } finally {
            System.out.println("Calling finally");
        }

    }

    static class Door implements java.lang.AutoCloseable {

        public Door() {
            System.out.println("Calling door constructor");
        }

        @Override
        public void close() throws IOException {
            System.out.println("calling close");
        }
    }
}
