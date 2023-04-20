package Patterns.Creational.Factory;

public class Main {

    public static void main(String[] args) {
        /*
         Factory
         Abstract Factory

         */

      /*  Pizza pepperoni = PizzaFactory.preparePizza("Pepperoni");
        Pizza hawaiian = PizzaFactory.preparePizza("Hawaiian");
        Pizza margarita = PizzaFactory.preparePizza("margarita");*/

        AbstractFactory<?> pizzaFactory = FactoryProvider.getFactory("Pizza");
        Object created = pizzaFactory.create("Hawaiian");



    }
}
