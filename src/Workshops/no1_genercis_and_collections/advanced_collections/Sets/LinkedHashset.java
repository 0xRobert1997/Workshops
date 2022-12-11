package Workshops.no1_genercis_and_collections.advanced_collections.Sets;

import java.util.Set;
import java.util.LinkedHashSet;

public class LinkedHashset {

    // linked trzyma kolejność dodawania\
    // ale i tak nie ma metody get
    public static void main(String[] args) {
        Set<String> dogs = new LinkedHashSet<>();
        dogs.add("doggo1");
        dogs.add("doggo2");
        dogs.add("doggo2");
        dogs.add("doggo3");
        dogs.add("doggo3");
        dogs.add("doggo4");
        dogs.add("doggo5");
        dogs.add("doggo5");
        dogs.add("doggo6");

        for (String dog : dogs) {
            System.out.println(dog);
        }


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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Dog dog)) return false;

            return getName() != null ? getName().equals(dog.getName()) : dog.getName() == null;
        }

        @Override
        public int hashCode() {
            return getName() != null ? getName().hashCode() : 0;
        }
    }
}
