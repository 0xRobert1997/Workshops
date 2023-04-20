package Patterns.Creational.Factory;

public class PepperoniPizza implements Pizza{
    @Override
    public String whatSauce() {
        return "Spicy";
    }

    @Override
    public void bake() {
        System.out.println("I'm so baking!");
    }

    public void beMoreSpiecy() {
        System.out.println("be more spicy!");
    }
}
