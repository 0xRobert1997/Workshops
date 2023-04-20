package Exercises.zad2_Factory;

public class ShapeFactory {

    public  Shape getShape(final String shape) {
        switch(shape) {
            case"CIRCLE":
                return new Circle();
            case"SQUARE":
                return new Square();
            default:
                throw new RuntimeException("This shape doesn't exist!");
        }
    }
}
