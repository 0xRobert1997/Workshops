package Exercises.zad11_Bridge;

public class PepperoniPizza implements Pizza {
    PizzaMaker pepperoniPizzaMaker;
    public PepperoniPizza(PizzaMaker pepperoniPizzaMaker) {
        this.pepperoniPizzaMaker = pepperoniPizzaMaker;
    }

    @Override
    public void preparePizza() {
        System.out.println("Preparing peperoni pizza");
    }
}
