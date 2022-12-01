package Workshops.no1_genercis.Lower_bound_wildcard;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());

        addFlyingDog(dogs);
        addFlyingDog(animals);

        // dziwny zapis mówi że w liście nie będzie nic co jest wyżej w hierarchi dziedziczenia niż Dog
        // czyli albo Dog albo niżej
        List<? super Dog> list1 = dogs;
        List<? super Dog> list2 = animals;
        list1.add(new Dog());
        list1.add(new FlyingDog());
        // animal już nie przejdzie
        // list1.add(new Animal());

    }

    private static void addFlyingDog(List<? super Dog> list) {
        list.add(new FlyingDog());
    }

    static class Animal {

    }

    static class Dog extends Animal {

    }

    static class FlyingDog extends Dog {

    }

}
