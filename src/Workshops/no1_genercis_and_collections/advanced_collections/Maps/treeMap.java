package Workshops.no1_genercis_and_collections.advanced_collections.Maps;

import java.util.Map;
import java.util.TreeMap;

public class treeMap {

    // też trzeba albo przekazać comparator albo klucz może implementować comparable
    public static void main(String[] args) {
        Map<Dog, String> treeMap = new TreeMap<>((o1, o2) -> o1.name.compareTo(o2.name));
        treeMap.put(new Dog("G5"), "some treeMap 3");
        treeMap.put(new Dog("A5"), "some treeMap 2");
        treeMap.put(new Dog("1A"), "some treeMap 1");
        treeMap.put(new Dog("o9"), "some treeMap 5");
        treeMap.put(new Dog("a2"), "some treeMap 4");
        System.out.println(treeMap);

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
