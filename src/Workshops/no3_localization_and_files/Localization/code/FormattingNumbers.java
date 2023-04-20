package Workshops.no3_localization_and_files.Localization.code;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbers {

    public static void main(String[] args) {

        int number = 1_234_567;
        Locale localePL = new Locale("pl", "PL");
        Locale localeUS = Locale.US;
        Locale localeGER = Locale.GERMANY;

        System.out.println("NumberFormat.getInstance(): ");
        System.out.println("PL: " + NumberFormat.getInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getInstance(localeUS).format(number));
        System.out.println("GERMANY: " + NumberFormat.getInstance(localeGER).format(number));
        System.out.println();

        System.out.println("NumberFormat.getNumberInstance(): ");
        System.out.println("PL: " + NumberFormat.getNumberInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getNumberInstance(localeUS).format(number));
        System.out.println("GERMANY: " + NumberFormat.getNumberInstance(localeGER).format(number));
        System.out.println();

        System.out.println("NumberFormat.getPercentInstance(): ");
        System.out.println("PL: " + NumberFormat.getPercentInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getPercentInstance(localeUS).format(number));
        System.out.println("GERMANY: " + NumberFormat.getPercentInstance(localeGER).format(number));
        System.out.println();

        System.out.println("NumberFormat.getCurrencyInstance(): ");
        System.out.println("PL: " + NumberFormat.getCurrencyInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getCurrencyInstance(localeUS).format(number));
        System.out.println("GERMANY: " + NumberFormat.getCurrencyInstance(localeGER).format(number));
        System.out.println();
    }
}
