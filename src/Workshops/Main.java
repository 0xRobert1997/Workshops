package Workshops;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Dog> dogList = Arrays.asList(new Dog(), new Dog());
        List<String> stringList = Arrays.asList("Super", "ekstra");
     //   print(stringList);
        print(dogList);

    }

    static void print(List<? extends Animal> list) {
        System.out.println(list);
    }

    static class Animal {

    }
    static class Dog extends Animal {

    }
}
