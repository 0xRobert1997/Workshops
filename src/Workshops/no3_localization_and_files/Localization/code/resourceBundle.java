package Workshops.no3_localization_and_files.Localization.code;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // ctrl+alt+shift+s -> modules -> i plik resources trzeba zaznaczyć jako resources
        //defaulotwy plik to ten który nie ma określonego locale w nazwie
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Store", new Locale("en", "US"));
        String mainPage = resourceBundle.getString("mainPage");
        String footer = resourceBundle.getString("footer");

        System.out.println(mainPage);
        System.out.println(footer);

        Map<String, String> collect = resourceBundle.keySet().stream()
                .collect(Collectors.toMap(key -> key, resourceBundle::getString));
        System.out.println(collect);

    }
}
