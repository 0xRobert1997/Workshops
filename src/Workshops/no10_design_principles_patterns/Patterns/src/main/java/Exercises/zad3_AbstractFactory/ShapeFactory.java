package Exercises.zad3_AbstractFactory;

public class ShapeFactory implements AbstractFactory<Shape>{

    @Override
    public Shape getShape(String shape) {
        switch(shape){
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            default:
                throw new RuntimeException("nooooo");
        }
    }

    @Override
    public Color getColor(String color) {
        throw new RuntimeException("");
    }

}
