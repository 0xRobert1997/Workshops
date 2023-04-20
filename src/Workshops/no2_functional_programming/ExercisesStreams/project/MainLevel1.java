package Workshops.no2_functional_programming.ExercisesStreams.project;

import Workshops.no2_functional_programming.ExercisesStreams.project.Source.DataFactory;
import Workshops.no2_functional_programming.ExercisesStreams.project.Source.Money;
import Workshops.no2_functional_programming.ExercisesStreams.project.Source.Purchase;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MainLevel1 {

    public static void main(String[] args) {

        List<Purchase> toOperate = DataFactory.produce();

        // 1. Oblicz jaka ilość klientów dokonała zakupu w naszym sklepie.

        HashSet<Purchase> collect = toOperate.stream()
                .collect(Collectors.toCollection(() -> new HashSet<>()));
        long count = collect.stream()
                .count();
        System.out.println("ilość unikalnych klientów: "+ count);

        // 2. Oblicz jaka ilość klientów płaciła Blikiem.

        long paidWithBlik = toOperate.stream()
                .filter(a -> a.getPayment() == Purchase.Payment.BLIK)
                .map(a -> a.getBuyer())
                .distinct()
                .count();

        System.out.println("ilość klientów która płaciła blikiem: " + paidWithBlik);

        // 3. Oblicz jaka ilość klientów płaciła kartą kredytową.

        long paidWithCard = toOperate.stream()
                .filter(a -> a.getPayment() == Purchase.Payment.CREDIT_CARD)
                .map(a -> a.getBuyer())
                .distinct()
                .count();

        System.out.println("ilość klientów która płaciła kartą: " + paidWithCard);

        // 4. Oblicz jaka ilość zakupów została wykonana w walucie EUR.

        long boughtWithEUR = toOperate.stream()
                .filter(a -> a.getProduct().getPrice().getCurrency() == Money.Currency.EUR)
                .count();

        System.out.println("Ilość zakupów zrobionych w EUR: " + boughtWithEUR);

        // 5. Oblicz ile unikalnych kupionych produktów zostało zakupionych w EUR.

        long uniqueProductBoughtWithEUR = toOperate.stream()
                .filter(a -> a.getProduct().getPrice().getCurrency() == Money.Currency.EUR)
                .map(a -> a.getProduct())
                .distinct()
                .count();

        System.out.println("ilość unikalnych produktów kupionych w EUR: " + uniqueProductBoughtWithEUR);

    }
}
