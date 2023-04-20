package Exercises.zad10_Decorator;

public abstract class ComponentDecorator implements Component{

    private final Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
        component.operation();
    }

    @Override
    public void operation() {

    }
}
