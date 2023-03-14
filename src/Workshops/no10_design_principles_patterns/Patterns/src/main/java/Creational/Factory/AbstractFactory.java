package Creational.Factory;

public interface AbstractFactory<T> {

    T create(String type);
}
