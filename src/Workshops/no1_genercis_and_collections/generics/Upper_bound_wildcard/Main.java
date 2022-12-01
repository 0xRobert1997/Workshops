package Workshops.no1_genercis.Upper_bound_wildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Monkey> monkeys = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<ImplementingVoiceable> implementingVoiceables = new ArrayList<>();

        print(animals);
        print(dogs);
        print(monkeys);
       // print(strings);
       // print(implementingVoiceables);

        // użyćie upper bound wildcard
        List<? extends Animal> list = dogs;
    }

    private static void print(List<? extends Animal> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }


    static class Animal implements Voiceable{

    }

    static class Monkey extends Animal{

    }
    static class Dog extends Animal{

    }

    static class ImplementingVoiceable implements Voiceable {

    }
    interface Voiceable {

    }
}
