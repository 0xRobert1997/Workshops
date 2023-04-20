package Exercises.zad3_AbstractFactory;

public interface AbstractFactory<T> {

    Shape getShape(String shape);
    Color getColor(String color);

}
