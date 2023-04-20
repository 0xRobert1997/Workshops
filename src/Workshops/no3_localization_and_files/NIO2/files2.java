package Workshops.no3_localization_and_files.NIO2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class files2 {

    public static void main(String[] args) {

        Path readingPath = Paths.get("src/Workshops/myFile.txt");

        try (BufferedReader reader = Files.newBufferedReader(readingPath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path writingPath = Paths.get("src/Workshops/myFileWritten.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(writingPath)) {
            writer.write("Zajavka1");
            writer.newLine();
            writer.write("Zajavka2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
