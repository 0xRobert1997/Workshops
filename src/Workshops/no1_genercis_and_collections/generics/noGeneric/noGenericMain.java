package Workshops.no1_genercis_and_collections.generics.noGeneric;

import java.util.ArrayList;
import java.util.List;

public class noGenericMain {

    public static void main(String[] args) {
        List dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Cat());
        print(dogs);

        List<Dog> dogs2 = new ArrayList<>();
        addDog(dogs2);

        List ints = new ArrayList();
        ints.add(15);
        Object o = ints.get(0);
        System.out.println(o);
    }

    private static void addDog(List dogs2) {
        dogs2.add(new Cat());
    }

    private static void print(List<Dog> dogs) {

    }

    static class Dog {

    }

    static class Cat {
        
    }
}
