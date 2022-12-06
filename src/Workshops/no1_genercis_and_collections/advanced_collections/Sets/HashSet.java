package Workshops.no1_genercis_and_collections.advanced_collections.Sets;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("Romek"));
        dogs.add(new Dog("Stefan"));
        dogs.add(new Dog("Romek"));
        dogs.add(new Dog("Zbyszek"));
        dogs.add(new Dog("Kiciek"));
        dogs.add(new Dog("Filip"));



    }

    private static class Dog {
        private String name;

        public String getName() {
            return name;
        }

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog" + name;
        }
    }
}
