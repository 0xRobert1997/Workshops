package Workshops.no11_next_java_versions.java16;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // records
    // nie mają setterów / zamiast geterów mają metody dostępowe

    // java dis-assembler - komenda javap - "rozmontowuje" klasę

    // Static nested class - od javy16 można deklarować zmienne statyczne w klasach zagnieżdżonych

    // instanceof - teraz już na stałe

    // streamy - zamiast .collect(Collectors.toList()); można napisać .toList();

    // DateTime - przy formatterze można dodać literke B

    // sealed classes - jako preview

    public static void main(String[] args) {

        Person<String> person1 = new Person<>("Karol", "Zajavkowy", 123L, "genericField");
        Person<Integer> person2 = new Person<>("Karol", "Zajavkowy", 123L, 420);
        System.out.println(person1.equals(person2));


        List<String> collect = Stream.of(1,2,3,5,9)
                .map(e -> e.toString())
                .toList();

        LocalTime time1 = LocalTime.parse("07:00:00");
        LocalTime time2 = LocalTime.parse("15:00:00");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss B");
        System.out.println(dateTimeFormatter.format(time1));
        System.out.println(dateTimeFormatter.format(time2));


    }
}
