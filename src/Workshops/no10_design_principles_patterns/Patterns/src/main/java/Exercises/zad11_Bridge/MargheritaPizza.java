package Exercises.zad11_Bridge;

public class MargheritaPizza implements Pizza {

    PizzaMaker margheritaPizzaMaker;
    public MargheritaPizza(PizzaMaker margheritaPizzaMaker) {
        this.margheritaPizzaMaker = margheritaPizzaMaker;
    }

    @Override
    public void preparePizza() {
        System.out.println("Preparing margherita pizza");
    }
}
