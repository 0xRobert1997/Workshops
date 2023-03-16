package Structural.Composite;

public class Elephant implements Animal{
    @Override
    public void eat(Food food) {
        System.out.println("Elephant eating: " + food);
    }
}
