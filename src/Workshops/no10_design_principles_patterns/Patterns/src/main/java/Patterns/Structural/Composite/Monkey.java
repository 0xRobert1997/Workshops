package Structural.Composite;

public class Monkey implements Animal{
    @Override
    public void eat(Food food) {
        System.out.println("monkey eating :" + food);
    }
}
