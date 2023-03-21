package Exercises.zad7_Composite;

import java.util.ArrayList;

public class Composite implements Component{

    private String name;
    private ArrayList<Component> components;

    public Composite(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void add(Component component) {
        components.add(component);
        System.out.println("Operation performed on a " + component.getClass().getSimpleName() + " " + component.getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public void operation() {
        System.out.println("Operation performed on a " + this.getClass().getSimpleName() + " " + this.getName());
    }
}
