package Creational.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class PizzaFactory implements AbstractFactory<Pizza>{

    private static final Map<String, Supplier<Pizza>> PIZZA_MAP = new HashMap<>();

    static {
            PIZZA_MAP.put("Pepperoni", PepperoniPizza::new);
            PIZZA_MAP.put("Hawaiian", HawaiianPizza::new);
    }

/*    public static Pizza preparePizza(final String whatPizza) {
        return Optional.ofNullable(PIZZA_MAP.get(whatPizza))
                .map(pizzaSupplier -> pizzaSupplier.get())
                .orElseThrow(() -> new RuntimeException("Sry, we don't sell that"));*/

//        switch(whatPizza) {
//            case "Pepperoni":
//                return new PepperoniPizza();
//            case "Hawaiian":
//                return new HawaiianPizza();
//            default:
//                throw new RuntimeException("Sorry we only sell Pepperoni or Hawaiian!");
//        }

//    }

    @Override
    public Pizza create(String type) {
        return Optional.ofNullable(PIZZA_MAP.get(type))
                .map(pizzaSupplier -> pizzaSupplier.get())
                .orElseThrow(() -> new RuntimeException("Sry, we don't sell that"));
    }
}
