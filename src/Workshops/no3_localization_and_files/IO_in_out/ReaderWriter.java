package Workshops.no3_localization_and_files.IO_in_out;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReaderWriter {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/Workshops/someFileInput.txt");
        File outputFile = new File("src/Workshops/someFileOutput.txt");

        List<String> fileRead = readFile(inputFile);
        fileRead.forEach(System.out::println);

        writeFile(outputFile, fileRead);
    }

    public static List<String> readFile(final File inputFile) throws IOException {
        List<String> result = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
        ) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        }
        return result;
    }

    private static void writeFile(File outputFile, List<String> fileRead) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))
        ) {
            for (String line : fileRead) {
                writer.write(line);
                writer.newLine();
            }
        }
    }


}
