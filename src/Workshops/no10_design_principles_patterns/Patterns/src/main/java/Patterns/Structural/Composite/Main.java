package Structural.Composite;

public class Main {

    public static void main(String[] args) {

        // base component - interfejs reprezentujący bazę rodziny
        // leaf - konkretna implementacja
        // composite - kolekcja liści

        ZOO zoo = new ZOO();
        zoo.add(new Monkey());
        zoo.add(new Monkey());
        zoo.add(new Tiger());
        zoo.add(new Elephant());
        zoo.eat(new Food());
    }
}
