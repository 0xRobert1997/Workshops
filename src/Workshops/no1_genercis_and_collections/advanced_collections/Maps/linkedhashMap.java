package Workshops.no1_genercis_and_collections.advanced_collections.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class linkedhashMap {

    // trzyma kolejnosc dodanych elementow
    public static void main(String[] args) {
        Map<Dog, Integer> someMap = new LinkedHashMap<>();
        someMap.put(new Dog("A"), 123);
        someMap.put(new Dog("E"), 123);
        someMap.put(new Dog("C"), 123);
        someMap.put(new Dog("D"), 123);
        someMap.put(new Dog("B"), 123);
        System.out.println(someMap);

        for (Map.Entry<Dog, Integer> stringIntegerEntry : someMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
    }

    private static class Dog {
        private final String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Dog " + name;
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
