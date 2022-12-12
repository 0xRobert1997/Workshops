package Workshops.no2_functional_programming.MethodReference;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String dejNejm() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog: " + name;
    }
}
