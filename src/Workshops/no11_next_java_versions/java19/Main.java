package Workshops.no11_next_java_versions.java19;

import java.util.Locale;

public class Main {

    // virtual thresds - preview
    // pattern matching for switch - kolejne zmiany jako preview
    // record patterns(rozszerzeniepattern matching instanceof) - preview
    // Locale - tworzenie przez metodę Locale.of()
    public static void main(String[] args) {

        Locale localePL1 = new Locale("pl", "PL");
        Locale localePL2 = Locale.of("pl", "PL");
    }
}
