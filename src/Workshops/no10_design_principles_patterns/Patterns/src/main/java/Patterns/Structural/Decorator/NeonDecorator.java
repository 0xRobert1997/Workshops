package Patterns.Structural.Decorator;

public class NeonDecorator extends CarDecorator {

    public NeonDecorator(Car car) {
        super(car);
    }

    @Override
    public String create() {
        System.out.println(this.getClass().getSimpleName() + " before super calling");
        String created = super.create();
        System.out.println(this.getClass().getSimpleName() + " after super calling");
        return created + withNeon();
    }

    private String withNeon() {
        return " with " + this.getClass().getSimpleName();
    }
}
