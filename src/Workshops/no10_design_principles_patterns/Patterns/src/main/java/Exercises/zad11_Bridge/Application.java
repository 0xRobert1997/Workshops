package Exercises.zad11_Bridge;



public class Application {
    public static void main(String[] args) {
        PizzaMaker margheritaPizzaMaker = new MargheritaPizzaMaker();
        Pizza margheritaPizza = new MargheritaPizza(margheritaPizzaMaker);
        margheritaPizza.preparePizza();
        PizzaMaker pepperoniPizzaMaker = new PepperoniPizzaMaker();
        Pizza pepperoniPizza = new PepperoniPizza(pepperoniPizzaMaker);
        pepperoniPizza.preparePizza();
    }
}
