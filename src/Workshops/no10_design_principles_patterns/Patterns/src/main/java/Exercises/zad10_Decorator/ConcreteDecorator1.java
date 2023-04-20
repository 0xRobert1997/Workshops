package Exercises.zad10_Decorator;

public class ConcreteDecorator1 extends ComponentDecorator {
    @Override
    public void operation() {
        System.out.println("Adding functionality in ConcreteDecorator1");
    }

    public ConcreteDecorator1(Component component) {
        super(component);
    }
}
