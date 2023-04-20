package Workshops.no3_localization_and_files.Localization.code;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingDates {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2010, Month.AUGUST, 2);
        LocalTime localTime = LocalTime.of(12, 52, 10);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(3));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Poland"));

        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter dateTimeFormatterFULL_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        DateTimeFormatter dateTimeFormatterFULL_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMANY);
        DateTimeFormatter dateTimeFormatterLONG_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.US);
        DateTimeFormatter dateTimeFormatterLONG_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.GERMANY);
        DateTimeFormatter dateTimeFormatterMEDIUM_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US);;
        DateTimeFormatter dateTimeFormatterMEDIUM_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY);;
        DateTimeFormatter dateTimeFormatterSHORT_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);
        DateTimeFormatter dateTimeFormatterSHORT_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.GERMANY);


        System.out.println(("FULL US: " + localDate.format(dateTimeFormatterFULL_US)));
        System.out.println(("FULL GER: " + localDate.format(dateTimeFormatterFULL_GER)));
        System.out.println(("LONG US: " + localDate.format(dateTimeFormatterLONG_US)));
        System.out.println(("LONG GER: " + localDate.format(dateTimeFormatterLONG_GER)));
        System.out.println(("MEDIUM US: " + localDate.format(dateTimeFormatterMEDIUM_US)));
        System.out.println(("MEDIUM GER: " + localDate.format(dateTimeFormatterMEDIUM_GER)));
        System.out.println(("SHORT US: " + localDate.format(dateTimeFormatterSHORT_US)));
        System.out.println(("SHORT GER: " + localDate.format(dateTimeFormatterSHORT_GER)));
    }
}
