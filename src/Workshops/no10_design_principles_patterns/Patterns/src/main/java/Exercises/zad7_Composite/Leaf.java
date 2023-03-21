package Exercises.zad7_Composite;

public class Leaf implements Component{
    private String name;
    public Leaf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void operation() {
        System.out.println("Operation performed on a " + this.getClass().getSimpleName() + " " + this.getName());
    }
}
