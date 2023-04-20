package Workshops.no3_localization_and_files.Exercises;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex3 {

    public static void main(String[] args) throws IOException {
        Path myPath = Paths.get("./src/Workshops/no3_localization_and_files/Exercises/nested1/w3-exercises-1-file-operations.pdf");
        printFileSize(myPath);
    }

    private static void printFileSize(Path myPath) throws IOException {
        long sizeB = Files.size(myPath);
        BigDecimal sizeKB = BigDecimal.valueOf(sizeB).divide(BigDecimal.valueOf(1000));
        BigDecimal sizeMB = sizeKB.divide(BigDecimal.valueOf(1000), RoundingMode.HALF_UP);

        System.out.printf("File %s, size of %s b / %s kb/ %s mb", myPath.getFileName(), sizeB, sizeKB, sizeMB);
    }
}
