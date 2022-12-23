package Workshops.no3_localization_and_files.Exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        example(Paths.get("someFile.txt"), Paths.get("someNewFile.txt"));
    }

    public static void example(final Path path1, final Path path2) {

        try (
                BufferedReader in = Files.newBufferedReader(path1);
                BufferedWriter out = Files.newBufferedWriter(path2);
        ) {
            String line = in.readLine() + "changed";
            out.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void example2(final Path path1, final Path path2) {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            in = Files.newBufferedReader(path1);
            out = Files.newBufferedWriter(path2);
            String line = in.readLine();
            out.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


