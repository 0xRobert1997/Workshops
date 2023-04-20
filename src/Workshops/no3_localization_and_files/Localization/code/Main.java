package Workshops.no3_localization_and_files.Localization.code;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        double amountOfMoney = 1_435_123.51;
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println(currencyInstance.format(amountOfMoney));

        LocalDateTime dateTime = LocalDateTime.of(2003, 12, 22, 21, 37);
        DateTimeFormatter myFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        dateTime.minus(Period.of(1,1,1));
    }
}
