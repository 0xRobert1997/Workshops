package Structural.Composite;

public class Tiger implements Animal{
    @Override
    public void eat(Food food) {
        System.out.println("Tiger eating: " + food);
    }
}
