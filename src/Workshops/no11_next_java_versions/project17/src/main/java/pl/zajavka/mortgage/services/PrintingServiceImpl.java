package pl.zajavka.mortgage.services;

import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Overpayment;
import pl.zajavka.mortgage.model.Rate;
import pl.zajavka.mortgage.model.Summary;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PrintingServiceImpl implements PrintingService {

    private static final Path RESULT_FILE_PATH = Paths.get("result.txt");

    private static final String SEPARATOR = createSeparator('-', 180);

    @SuppressWarnings("SameParameterValue")
    private static String createSeparator(char sign, int length) {
        return String.valueOf(sign).repeat(Math.max(0, length)) + System.lineSeparator();
    }

    @Override
    public void printIntroInformation(InputData inputData) {
        String introInformation = INTRO_INFORMATION.formatted(
                inputData.amount(),
                inputData.monthsDuration(),
                inputData.interestToDisplay(),
                inputData.overpaymentStartMonth()
        );

        if (Optional.ofNullable(inputData.overpaymentSchema()).map(schema -> schema.size() > 0).orElse(false)) {
            String overpaymentMessage = OVERPAYMENT_INFORMATION.formatted(
                    Overpayment.REDUCE_PERIOD.equals(inputData.overpaymentReduceWay())
                            ? OVERPAYMENT_REDUCE_PERIOD
                            : OVERPAYMENT_REDUCE_RATE,
                    overpaymentSchemaMessage(inputData.overpaymentSchema())

            );
            introInformation += overpaymentMessage;
        }


        log(introInformation);
    }

    private void logOverpayment(final StringBuilder msg, final Map<Integer, BigDecimal> schema, final String reduceWay) {
        switch (reduceWay) {
            case Overpayment.REDUCE_PERIOD -> msg.append(OVERPAYMENT_REDUCE_PERIOD);
            case Overpayment.REDUCE_RATE -> msg.append(OVERPAYMENT_REDUCE_RATE);
            default -> throw new MortgageException("Case not handled");
        }
        msg.append(System.lineSeparator());
        msg.append(OVERPAYMENT_FREQUENCY).append(System.lineSeparator()).append(overpaymentSchemaMessage(schema));
    }

    private String overpaymentSchemaMessage(Map<Integer, BigDecimal> schema) {
        return schema.entrySet().stream()
                .reduce(
                        new StringBuilder(),
                        (previous, next) -> previous.append(String.format(OVERPAYMENT_SCHEMA, next.getKey(), next.getValue())),
                        StringBuilder::append).toString();
    }

    @Override
    public void printSchedule(final List<Rate> rates, final InputData inputData) {
        if (!inputData.mortgagePrintPayoffsSchedule()) {
            return;
        }

        rates.stream()
                .filter(rate -> rate.rateNumber().remainder(BigDecimal.valueOf(inputData.mortgageRateNumberToPrint())).equals(BigDecimal.ZERO))
                .forEach(rate -> {
                    log(formatRateLine(rate));
                    if (AmountsCalculationService.YEAR.equals(rate.timePoint().month())) {
                        log(SEPARATOR);
                    }
                });

        int index = 1;
        for (Rate rate : rates) {
            if (rate.rateNumber().remainder(BigDecimal.valueOf(inputData.mortgageRateNumberToPrint())).equals(BigDecimal.ZERO)) {
                if (index % AmountsCalculationService.YEAR.intValue() == 0) {
                    log(SEPARATOR);
                }
                index++;
            }
        }
        log(System.lineSeparator());
    }

    private static String formatRateLine(Rate rate) {
        return String.format(SCHEDULE_TABLE_FORMAT,
                RATE_LINE_KEYS.get(0), rate.rateNumber(),
                RATE_LINE_KEYS.get(1), rate.timePoint().year(),
                RATE_LINE_KEYS.get(2), rate.timePoint().month(),
                RATE_LINE_KEYS.get(3), rate.timePoint().date(),
                RATE_LINE_KEYS.get(4), rate.rateAmounts().rateAmount(),
                RATE_LINE_KEYS.get(5), rate.rateAmounts().interestAmount(),
                RATE_LINE_KEYS.get(6), rate.rateAmounts().capitalAmount(),
                RATE_LINE_KEYS.get(7), rate.rateAmounts().overpayment().amount(),
                RATE_LINE_KEYS.get(8), rate.mortgageResidual().residualAmount(),
                RATE_LINE_KEYS.get(9), rate.mortgageResidual().residualDuration()
        );
    }

    @Override
    public void printSummary(final Summary summary) {

        String msg = SUMMARY_INFORMATION.formatted(
                summary.interestSum(),
                summary.overpaymentProvisionSum().setScale(2, RoundingMode.HALF_UP),
                summary.totalLostSum().setScale(2, RoundingMode.HALF_UP),
                summary.totalCapital().setScale(2, RoundingMode.HALF_UP)
        );
        log(msg);
    }

    private void log(String message) {
        System.out.println(message);

        try {
            if (!Files.exists(RESULT_FILE_PATH)) {
                Files.createFile(RESULT_FILE_PATH);
            }
            Files.writeString(RESULT_FILE_PATH, message, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
