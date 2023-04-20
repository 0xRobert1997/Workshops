package Exercises.zad3_AbstractFactory;

public class ColorFactory implements AbstractFactory<Color>{
    @Override
    public Shape getShape(String shape) {
        throw new RuntimeException("aaa");
    }

    @Override
    public Color getColor(String color) {
        switch (color) {
            case "BLUE":
                return new Blue();
            case "RED":
                return new Red();
            default:
                throw new RuntimeException("aaaa");
        }
    }
}
