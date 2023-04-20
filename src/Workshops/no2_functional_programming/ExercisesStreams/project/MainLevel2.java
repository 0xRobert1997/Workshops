package Workshops.no2_functional_programming.ExercisesStreams.project;

import Workshops.no2_functional_programming.ExercisesStreams.project.Source.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainLevel2 {

    private static BigDecimal allSpend = BigDecimal.ZERO;

    public static void main(String[] args) {

        List<Purchase> toOperate = DataFactory.produce();

        System.out.println("Zadanie1: ");
        zad1(toOperate);

        System.out.println("Zadanie2: ");
        System.out.println(zad2(Product.Category.HOBBY));

        System.out.println("Zadanie3: tylko aktualizuje status, nic nie drukuje");
        zad3(toOperate);

        System.out.println("Zadanie4: ");
        System.out.println(zad4( toOperate));

        System.out.println("Zadanie5: ");
        System.out.println(zad5( toOperate));

        System.out.println("Zadanie6: ");
        System.out.println(zad6( toOperate));

        System.out.println("Zadanie7: ");
        zad7( toOperate);

    }

    private static void zad1(List<Purchase> toProcess) {

        // wyrzuci wyjątek bo doda kilka takich samych kluczy
        // trzeba dodać mergeFunction (binaryOperator)
        Map<Client, BigDecimal> clientMoneyMap = toProcess.stream()
                .collect(Collectors
                        .toMap(key -> key.getBuyer()
                                , value -> value.getProduct().getPrice().getValue()
                                        .multiply(BigDecimal.valueOf(value.getQuantity()))
                                , (value1, value2) -> value1.add(value2)));


        Stream.of(clientMoneyMap)
                .forEach(System.out::println);

    }

    private static Map<String, Long> zad2(Product.Category category) {

        List<Purchase> toOperate = DataFactory.produce();

        Map<String, Long> collect = toOperate.stream()
                .filter(a -> a.getQuantity() > 1)
                .filter(a -> a.getProduct().getCategory() == category)
                .collect(Collectors
                        .toMap(key -> key.getBuyer().getId(), value -> value.getQuantity()
                                , (value1, value2) -> value1 + value2));
        return collect;
    }

    private static void zad3( List<Purchase> toOperate) {

        toOperate.stream()
                .forEach(a -> OrderService.checkOrderStatus(a));
    }

    private static Map<Client, List<Product>> zad4(List<Purchase> toOperate) {

        Set<Purchase> collect = toOperate.stream()
                .filter(a -> a.getProduct().getPrice().getCurrency() == Money.Currency.EUR)
                .collect(Collectors.toSet());

        long count = collect.stream()
                .count();

        System.out.println("Liczba unikalnych klientów którzy kupili produkt w EUR: " + count);

        Map<Client, List<Product>> collect1 = toOperate.stream()
                .collect(Collectors
                        .toMap(key -> key.getBuyer(),
                                value -> new ArrayList<>(Arrays.asList(value.getProduct())),
                                (value1, value2) -> {
                                    value1.addAll(value2);
                                    return value1;
                                }));
        return collect1;
    }


    private static Map<String, List<Product>> zad5(List<Purchase> toOperate) {


        TreeMap<String, List<Product>> collect = toOperate.stream()
                .collect(Collectors.toMap(key -> {
                                    String a = "";
                                    String temp = key.getBuyer().getPesel().toString();
                                    a+= temp.charAt(0);
                                    a+= temp.charAt(1);
                                    return a;
                                },
                                value -> new ArrayList<>(Arrays.asList(value.getProduct())),
                                (value1, value2) -> {
                                    value1.addAll(value2);
                                    return value1;
                                }, () -> new TreeMap<>())
                );

        Map<String, List<Product>> sortedMap = collect.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        return sortedMap;
    }


    private static TreeMap<String,TreeSet<Product.Category>> zad6(List<Purchase> toOperate) {


        TreeMap<String, TreeSet<Product.Category>> collect = toOperate.stream()
                .collect(Collectors.toMap(key -> {
                            String a = "";
                            String temp = key.getBuyer().getPesel().toString();
                            a += temp.charAt(0);
                            a += temp.charAt(1);
                            return a;
                        },
                        value -> {
                            TreeSet<Product.Category> set = new TreeSet<>();
                            set.add(value.getProduct().getCategory());
                            return set;
                        },
                        (value1, value2) -> {
                            TreeSet<Product.Category> result = new TreeSet<>();
                            result.addAll(value1);
                            result.addAll(value2);
                            return result;
                        }, () -> new TreeMap<>()));
        return collect;


    }


    private static void zad7(List<Purchase> toOperate) {

        Map<Product, Long> collect = toOperate.stream()
                .collect(Collectors.toMap(
                        key -> key.getProduct(),
                        value -> value.getQuantity(),
                        (value1, value2) -> value1 + value2,
                        ( () -> new TreeMap<>() )));

        collect.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(System.out::println);
    }




























}
