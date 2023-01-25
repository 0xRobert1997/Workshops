package code;

import org.jsoup.Jsoup;

import java.io.IOException;

public class Main {
    /*

   .jar - java archive
    mvn compile -X (wyświetla więcej informacji)

    */
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        System.out.println(Jsoup.connect("https://app.zajavka.pl").get().title());
    }
}
