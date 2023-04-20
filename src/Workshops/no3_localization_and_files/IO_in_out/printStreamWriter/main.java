package Workshops.no3_localization_and_files.IO_in_out.printStreamWriter;

import java.io.*;

public class main {

    public static void main(String[] args) {

        File file = new File("example.txt");

        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)))
        ) {
            writer.print(1L);
            writer.write("xd");
            Car car = new Car ("Stefan");
            writer.print(car);
            writer.println();
            writer.println("Zajavka");
            writer.printf("somevalue, [%s] %n", car);
            writer.printf("somevalue, [%s] %n", car);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
