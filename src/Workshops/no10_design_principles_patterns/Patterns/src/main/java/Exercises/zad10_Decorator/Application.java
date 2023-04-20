package Exercises.zad10_Decorator;

public class Application {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
        component = new ConcreteDecorator2(component);
        component.operation();
    }
}
/*
Performing operation on the concrete component
Adding additional functionality in ConcreteDecorator1
Adding additional functionality in ConcreteDecorator2
 */