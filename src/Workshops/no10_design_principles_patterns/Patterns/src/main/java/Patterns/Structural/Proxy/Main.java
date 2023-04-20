package Patterns.Structural.Proxy;

public class Main {

    public static void main(String[] args) {

        PizzaBaker executor = new PizzaBakerProxy(new PizzaBakerImpl());
        executor.bake("Pepperoni");
        executor.bake("Margeritta");
        executor.bake("Hawaiian");
    }
}
