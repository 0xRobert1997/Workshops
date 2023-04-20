package Exercises.zad3_AbstractFactory;

public class AbstractFactoryImpl {

    public static AbstractFactory<?> getFactory(String whatFactory) {

        switch (whatFactory) {
            case "SHAPE":
                return new ShapeFactory();
            case "COLOR":
                return new ColorFactory();
            default:
                throw new RuntimeException("upsik");
        }
    }
}
