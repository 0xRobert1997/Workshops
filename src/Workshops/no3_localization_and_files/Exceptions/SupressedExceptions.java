package Workshops.no3_localization_and_files.Exceptions;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SupressedExceptions {

    public static void main(String[] args) {

        try (Door door = new Door()) {
            throw new RuntimeException("Exception while opening the door!");
        } catch (Exception e) {
            for (Throwable throwable: e.getSuppressed()) {
                System.out.println("Normal exception: " + e.getMessage());
                System.out.println("supressed: " + throwable.getMessage());
            }
        } finally {
            System.out.println("Calling finally");
            throw new RuntimeException("Exception in finally: ");
        }

    }



    static class Door implements java.lang.AutoCloseable {

        public Door() {
            System.out.println("Calling door constructor");
            throw new RuntimeException("Some exception ocurred during close()");
        }

        @Override
        public void close() throws IOException {
            System.out.println("calling close");
        }
    }
}
