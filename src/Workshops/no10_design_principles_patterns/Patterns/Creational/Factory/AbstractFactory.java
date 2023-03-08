package Workshops.no10_design_principles_patterns.Patterns.Factory;

public interface AbstractFactory<T> {

    T create(String type);
}
