package Structural.Proxy;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PizzaBakerProxy implements PizzaBaker{

    private static final List<String> DENIED_PIZZAS = List.of("Hawaiian");

    private final PizzaBaker pizzaBaker;

    @Override
    public void bake(String pizza) {
        if (DENIED_PIZZAS.contains(pizza)) {
            throw new RuntimeException("o no no no no!");
        } else {
            System.out.println("Baking pizza: " + pizza);
        }
    }

}
