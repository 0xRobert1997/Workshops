package code;

import org.jsoup.Jsoup;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        System.out.println(Jsoup.connect("https://app.zajavka.pl").get().title());
    }
}
