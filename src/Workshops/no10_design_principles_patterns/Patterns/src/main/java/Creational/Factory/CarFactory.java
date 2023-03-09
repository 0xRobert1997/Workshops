package Workshops.no10_design_principles_patterns.Patterns.Creational.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class CarFactory implements AbstractFactory<Car>{

    private static final Map<String, Supplier<Car>> CAR_MAP = new HashMap<>();

    static {
            CAR_MAP.put("SUV", () -> new SUV());
            CAR_MAP.put("Cabriolet", () -> new Cabriolet());
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
    public Car create(String type) {
        return Optional.ofNullable(CAR_MAP.get(type))
                .map(CarSupplier -> CarSupplier.get())
                .orElseThrow(() -> new RuntimeException("Sry, we don't sell that"));
    }
}
