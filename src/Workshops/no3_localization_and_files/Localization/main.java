package Workshops.no3_localization_and_files;

import java.util.Locale;


public class main {

    public static void main(String[] args) {

        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);

        System.out.println(new Locale("pl"));
        System.out.println(new Locale("pl", "PL"));



    }
}
