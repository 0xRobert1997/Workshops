package Exercises.zad10_Decorator;

public class ConcreteDecorator2 extends ComponentDecorator  {
    @Override
    public void operation() {
        System.out.println("Adding functionality in ConcreteDecorator2");
    }

    public ConcreteDecorator2(Component component) {
        super(component);
    }
}
