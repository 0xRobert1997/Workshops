package Workshops.no2_functional_programming.ExercisesStreams.project;

import Workshops.no2_functional_programming.ExercisesStreams.project.Source.DataFactory;
import Workshops.no2_functional_programming.ExercisesStreams.project.Source.Product;
import Workshops.no2_functional_programming.ExercisesStreams.project.Source.Purchase;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class MainLevel3 {

    public static void main(String[] args) {
        List<Purchase> toOperate = DataFactory.produce();

        System.out.println("Zadanie1: ");
        zad1(toOperate);

        System.out.println("Zadanie2: ");
        zad2(toOperate);
    }

    private static void zad1(List<Purchase> toOperate) {

        List<Purchase> ListWithPurchases50plus = toOperate.stream()
                .filter(purchase -> {
                    BigInteger pesel = purchase.getBuyer().getPesel();
                    String stringPesel = String.valueOf(pesel);
                    stringPesel = stringPesel.substring(0, 2);
                    Integer yearOfBorn = Integer.parseInt(stringPesel);
                    purchase.getBuyer().setYear(yearOfBorn);
                    if (yearOfBorn < 72 && !(yearOfBorn < 22)) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        Map<Integer, Map<Product.Category, Long>> collect = ListWithPurchases50plus.stream()
                .collect(Collectors.toMap(
                        key -> key.getBuyer().getYear(),
                        value -> {
                            Map mapInMap = new TreeMap();
                            mapInMap.put(value.getProduct().getCategory(), value.getQuantity());
                            return mapInMap;
                        }, (value1, value2) -> {
                            Map mapInMap2 = new TreeMap<Product.Category, Long>();
                            mapInMap2.putAll(value1);
                            mapInMap2.putAll(value2);
                            return mapInMap2;
                        }
                        ));
        for (Map.Entry<Integer, Map<Product.Category, Long>> integerMapEntry : collect.entrySet()) {
            System.out.println(integerMapEntry);
        }

    }

    private static void zad2(List<Purchase> toOperate) {

        Map<Integer, Long> collect = toOperate.stream()
                .filter(purchase -> {
                    BigInteger pesel = purchase.getBuyer().getPesel();
                    String stringPesel = String.valueOf(pesel);
                    stringPesel = stringPesel.substring(0, 2);
                    Integer yearOfBorn = Integer.parseInt(stringPesel);
                    purchase.getBuyer().setYear(yearOfBorn);
                    return true;
                })
                .collect(Collectors.toMap(key -> key.getBuyer().getYear(),
                        value -> value.getQuantity(),
                        (value1, value2) -> value1 + value2));


        System.out.println(collect);
    }
}
