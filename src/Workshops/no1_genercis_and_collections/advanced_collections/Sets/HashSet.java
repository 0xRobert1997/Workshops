package Workshops.no1_genercis_and_collections.advanced_collections.Sets;

import java.util.Set;

public class HashSet {

    public static void main(String[] args) {
        Set<Dog> dogs = new java.util.HashSet<>();
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
