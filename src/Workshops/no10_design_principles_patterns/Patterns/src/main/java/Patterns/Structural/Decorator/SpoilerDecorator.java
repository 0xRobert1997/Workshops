package Patterns.Structural.Decorator;

public class SpoilerDecorator extends CarDecorator{

    public SpoilerDecorator(Car car) {
        super(car);
    }

    @Override
    public String create() {
        return super.create() + withSpoiler();
    }

    private String withSpoiler() {
        return " with " + this.getClass().getSimpleName();
    }
}
