package Behavioral.Visitor;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        List<ShoppingCartElement> elements = List.of(
                new Bicycle(BigDecimal.valueOf(100.25), BigDecimal.TEN),
                new Bicycle(BigDecimal.valueOf(321), BigDecimal.TEN),
                new Apple(BigDecimal.valueOf(4), BigDecimal.ONE),
                new Apple(BigDecimal.valueOf(4), BigDecimal.valueOf(3)
        ));


        ShoppingCartVisitorMap visitorMap = new ShoppingCartVisitorMap();

        BigDecimal result = elements.stream()
                .map(element -> element.accept(visitorMap.apply(element.getClass())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total value of cart: " + result);
    }
}
