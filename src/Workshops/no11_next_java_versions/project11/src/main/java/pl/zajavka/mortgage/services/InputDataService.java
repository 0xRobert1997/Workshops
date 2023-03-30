package pl.zajavka.mortgage.services;

import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.MortgageType;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputDataService {

    private static final Path FILE_LOCATION = Paths.get("src/main/resources/inputData.csv");

    public InputData read() throws IOException {
        Map<String, List<String>> content = Files.readString(FILE_LOCATION)
                .lines()
                .collect(Collectors.groupingBy(line -> line.split(";")[0]));

        validate(content);

        Map<String, String> inputData = content.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().get(0).split(";")[1]));

        return new InputData()
                .withRepaymentStartDate(
                        Optional.ofNullable(inputData.get("RepaymentStartDate"))
                        .map(e -> LocalDate.parse(e))
                                .orElseThrow())
                .withWiborPercent(
                        Optional.ofNullable(inputData.get("Wibor")).map(BigDecimal::new).orElseThrow())
                .withAmount(
                        Optional.ofNullable(inputData.get("Amount")).map(BigDecimal::new).orElseThrow())
                .withMonthsDuration(
                        Optional.ofNullable(inputData.get("MonthsDuration")).map(BigDecimal::new).orElseThrow())
                .withType(
                        Optional.ofNullable(inputData.get("RateType")).map(MortgageType::valueOf).orElseThrow())
                .withMarginPercent(
                        Optional.ofNullable(inputData.get("Margin")).map(BigDecimal::new).orElseThrow())
                .withOverpaymentProvisionPercent(
                        Optional.ofNullable(inputData.get("OverpaymentProvision")).map(BigDecimal::new).orElseThrow())
                .withOverpaymentProvisionMonths(
                        Optional.ofNullable(inputData.get("OverpaymentProvisionMonths")).map(BigDecimal::new).orElseThrow())
                .withOverpaymentStartMonth(
                        Optional.ofNullable(inputData.get("OverpaymentStartMonth")).map(BigDecimal::new).orElseThrow())
                .withOverpaymentSchema(
                        Optional.ofNullable(inputData.get("OverpaymentSchema")).map(this::calculateSchema).orElseThrow())
                .withOverpaymentReduceWay(
                        inputData.get("OverpaymentReduceWay"))
                .withMortgagePrintPayoffsSchedule(
                        Optional.ofNullable(inputData.get("MortgagePrintPayoffsSchedule")).map(Boolean::parseBoolean).orElseThrow())
                .withMortgageRateNumberToPrint(
                        Optional.ofNullable(inputData.get("MortgageRateNumberToPrint")).map(Integer::parseInt).orElseThrow());
    }

    private Map<Integer, BigDecimal> calculateSchema(String schema) {
        return Stream.of(schema.split(","))
                .map(entry -> Map.entry(entry.split(":")[0], entry.split(":")[1]))
                .collect(Collectors.toMap(
                        entry -> Integer.parseInt(entry.getKey()),
                        entry -> new BigDecimal(entry.getValue()),
                (v1, v2) -> v2,
                        TreeMap::new
        ));
    }

    private void validate(final Map<String, List<String>> content) {
        if (content.values().stream().anyMatch(values -> values.size() != 1))
            throw new IllegalArgumentException("Configuration mismatch");
    }
}
