package Exercises.zad3_AbstractFactory;

public class Application {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = AbstractFactoryImpl.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape1.draw();
        shape2.draw();
        AbstractFactory colorFactory = AbstractFactoryImpl.getFactory("COLOR");
        Color color1 = colorFactory.getColor("RED");
        Color color2 = colorFactory.getColor("BLUE");
        color1.fill();
        color2.fill();
    }
}
