package Workshops.no3_localization_and_files.Exercises.project.services;

import Workshops.no3_localization_and_files.Exercises.project.domain.Pair;
import Workshops.no3_localization_and_files.Exercises.project.domain.Purchase;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Main {

    public static final String myStringPath = "./src/Workshops/no3_localization_and_files/Exercises/project//exported/ex2";

    public static void main(String[] args) {
        Path spreadsheet =
                Paths.get("./src/Workshops/no3_localization_and_files/Exercises/project/purchase-spreadsheet.csv");

        List<Purchase> purchases = FileService.loadData(spreadsheet);

        // ex2
        Map<String, List<Purchase>> mapByCompany = purchases.stream()
                .collect(Collectors.groupingBy(p -> p.getCar().getCompany()));

        createFilesGroupedByCompany(mapByCompany);
        printSortedByCompany();

        ex3(mapByCompany);

        // ex4
        ex4(purchases);
    }

    private static void ex3(Map<String, List<Purchase>> mapByCompany) {
        Map<String, Map<String, List<Purchase>>> mapByCompanyAndModel = mapByCompany.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().stream()
                                .collect(Collectors.groupingBy(p -> p.getCar().getModel()))
                ));

        Map<String, Map<String, Pair<BigDecimal, Long>>> ex3ReportMap = mapByCompanyAndModel.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        // value jest mapą w mapByCompanyAndModel
                        entry -> entry.getValue().entrySet().stream()
                                .collect(Collectors.toMap(
                                        entry1 -> entry1.getKey(),
                                        entry1 -> buildPair(entry1.getValue())
                                ))
                ));

        AtomicInteger counter = new AtomicInteger(1);
        List<String> ex3ReportData = ex3ReportMap.entrySet().stream()
                .flatMap(eExternal -> eExternal.getValue().entrySet().stream()
                        .map(eInternal -> getRawRow(counter.getAndIncrement(), eExternal.getKey(), eInternal.getKey(), eInternal.getValue()))
                )
                .toList();

        generateEx3Report(ex3ReportData);
    }

    private static void generateEx3Report(List<String> data) {
        Path path = Paths.get("./src/Workshops/no3_localization_and_files/Exercises/project//exported/ex3/report.csv");
        FileService.saveToFile(path, data, "id,company,model,average-price,count");
    }

    private static String getRawRow(int counter, String company, String model, Pair<BigDecimal, Long> pair) {
        return String.format("%s,%s,%s,%s,%s", counter, company, model, pair.getP1(), pair.getP2());
    }

    private static Pair<BigDecimal, Long> buildPair(List<Purchase> purchaseList) {
        long count = purchaseList.size();
        BigDecimal averagePrice = purchaseList.stream()
                .map(a -> a.getCar().getPrice())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b))
                .divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        return new Pair<>(averagePrice, count);
    }

    private static Number getFileSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String getCompanyFromFileName(Path path) {
        return path.getFileName()
                .toString()
                .substring(13, path.getFileName().toString().length() - 4);
    }

    private static void createFilesGroupedByCompany(Map<String, List<Purchase>> mapByCompany) {
        for (Map.Entry<String, List<Purchase>> entry : mapByCompany.entrySet()) {
            Path companyPath = Paths.get(myStringPath + "/purchases-of-" + entry.getKey() + ".csv");

            List<String> data = entry.getValue().stream()
                    .map(PurchaseMappingService::getCsvRow)
                    .toList();
            FileService.saveToFile(companyPath, data);
        }
    }

    private static void printSortedByCompany() {
        try {
            TreeMap<String, ? extends Number> mapSizeByCompany = Files.list(Paths.get(myStringPath))
                    .collect(Collectors.toMap(
                            Main::getCompanyFromFileName,
                            Main::getFileSize,
                            (a, b) -> a,
                            () -> new TreeMap<>(Comparator.reverseOrder())
                    ));

            for (String company : mapSizeByCompany.keySet()) {
                System.out.printf("%s:%s%n", company, mapSizeByCompany.get(company));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ex4(List<Purchase> purchases) {
        TreeMap<LocalDate, Long> mapByDate = purchases.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getPurchaseDate(),
                        () -> new TreeMap<>(),
                        Collectors.counting()
                ));

        AtomicInteger counter = new AtomicInteger(1);
        List<String> dataByDate = mapByDate.entrySet().stream()
                .map(e -> String.format("%s,%s,%s", counter.getAndIncrement(), e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        generateEx4Report(dataByDate, "ByDate");

        AtomicInteger counter2 = new AtomicInteger(1);
        List<String> dataByCount = mapByDate.entrySet().stream()
                .map(e -> new Pair<>(e.getValue(), e.getKey()))
                .sorted(Comparator.comparing((Pair<Long, LocalDate> p) -> p.getP1()).reversed())
                .map(p -> String.format("%s,%s,%s", counter2.getAndIncrement(), p.getP2(), p.getP1()))
                .collect(Collectors.toList());
    }

    private static void generateEx4Report(List<String> data, String suffix) {
        Path path = Paths.get("./src/Workshops/no3_localization_and_files/Exercises/project//exported/ex4/report" + suffix + ".csv");
        FileService.saveToFile(path, data, "id,date,count");
    }
}
