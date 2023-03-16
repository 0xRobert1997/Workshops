package Behavioral.Visitor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

public class ShoppingCartVisitorMap implements Function<Class<? extends ShoppingCartElement>, ShoppingCartVisitor> {


    private static final Map<Class<? extends ShoppingCartElement>, ? extends ShoppingCartVisitor> VISITORS = Map.of(
            Apple.class, element -> visit((Apple) element),
            Bicycle.class, element -> visit((Bicycle) element)
    );                                                 //^^ bez rzutowania byłby błąd kompilacji
                                                        // ewentualnie można by zrobić 1 metodę visit z ifem
    private static BigDecimal visit(final Apple apple) {
        BigDecimal totalCost = apple.getWeight().multiply(apple.getPricePerKg());
        System.out.println("Calculated apple cost: " + totalCost);
        return totalCost;
    }

    private static BigDecimal visit(final Bicycle bicycle) {
        BigDecimal totalCost = bicycle.getPrice().subtract(bicycle.getDiscount());
        System.out.println("Calculated bicycle cost: " + totalCost);
        return totalCost;
    }


    @Override
    public ShoppingCartVisitor apply(Class<? extends ShoppingCartElement> aClass) {
        return VISITORS.get(aClass);
        // aClass bo Class jest słówkiem zastrzerzonym
    }
}
