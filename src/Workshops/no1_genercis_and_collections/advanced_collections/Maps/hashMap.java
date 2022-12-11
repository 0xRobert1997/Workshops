package Workshops.no1_genercis_and_collections.advanced_collections.Maps;

import java.util.HashMap;
import java.util.Map;

public class hashMap {

    public static void main(String[] args) {
        Map<String, String> someMap = new HashMap<>();
        someMap.put("1", "ABC");
        someMap.put("2", "DEF");
        someMap.put("3", "GHI");
        someMap.put("4", "JKL");

        for (String s : someMap.keySet()) {
            System.out.println(s + ", ");
        }
        for (String value : someMap.values()) {
            System.out.println(value + ", ");
        }
        for (Map.Entry<String, String> entry : someMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        System.out.println(someMap.getOrDefault("444", "no nie ma xd"));


        Map<Dog, String> dogStringMap = new HashMap<>();
        dogStringMap.put(new Dog("Romek"), "ma swoj domek");
        dogStringMap.put(new Dog("Stefan"), "ma swoj polek");
        dogStringMap.put(new Dog("Zbyszek"), "ma swoj atomek");
        dogStringMap.put(new Dog("Stefan"), "ma swoj bolek");
        System.out.println(dogStringMap);

    }

    private static class Dog {
        private String name;

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
