package Patterns.Structural.Composite;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ZOO implements Animal{

    private final List<Animal> animals = new ArrayList<>();

    @Override
    public void eat(Food food) {
        animals.forEach(animal -> animal.eat(food));
    }


    public void add(Animal animal) {
        this.animals.add(animal);
    }

    public void remove(Animal animal) {
        this.animals.remove(animal);
    }

    public void clear() {
        this.animals.clear();
    }
}
