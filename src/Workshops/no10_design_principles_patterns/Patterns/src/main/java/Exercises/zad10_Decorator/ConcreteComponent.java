package Exercises.zad10_Decorator;

public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("Performing operation on the concrete component");
    }
}
