package Creational.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class FactoryProvider {

    private static final Map<String, Supplier<AbstractFactory<?>>> FACTORIES_MAP = new HashMap<>();

    static {
        FACTORIES_MAP.put("Pizza", () -> new PizzaFactory());
        FACTORIES_MAP.put("Car", () -> new CarFactory());
    }
    public static AbstractFactory<?> getFactory(String whatFactory) {
        return Optional.ofNullable(FACTORIES_MAP.get(whatFactory))
                .map(supplier -> supplier.get())
                .orElseThrow( () -> new RuntimeException("sry, we only produce pizzas and cars"));


    }
}
