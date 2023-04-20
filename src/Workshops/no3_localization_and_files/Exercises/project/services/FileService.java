package Workshops.no3_localization_and_files.Exercises.project.services;

import Workshops.no3_localization_and_files.Exercises.project.domain.Purchase;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


public class FileService {

    public static List<Purchase> loadData(Path path) {
        try {
            List<Purchase> collect = Files.lines(path)
                    .skip(1)
                    .map(line -> PurchaseMappingService.getPurchase(line))
                    .collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void saveToFile(Path path, List<String> data) {
        String header = "id,first_name,last_name,email,ip_address,color,car_vin,car_company,car_model,car_model_year,car_price,country,city,date";

        saveToFile(path, data, header);
    }

    public static void saveToFile(Path path, List<String> data, String header) {
        try {
            Files.createDirectories(path.subpath(0, path.getNameCount() - 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            writer.write(header);
            writer.newLine();

            for (String row : data) {
                writer.write(row);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
