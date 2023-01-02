package Workshops.no3_localization_and_files.IO_in_out;

import java.io.*;

public class printStreamWriter {

    public static void main(String[] args) {

        File file = new File("example.txt");

        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)))) {

            writer.print(1L);
            writer.write("xd");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
