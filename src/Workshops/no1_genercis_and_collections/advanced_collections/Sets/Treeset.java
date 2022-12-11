package Workshops.no1_genercis_and_collections.advanced_collections.Sets;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.HashSet;


public class Treeset {
    // obiekty które dodajemy do treeset'u muszą implementować comparable albo można podać jakiś comparator
    // bo treeset pod spodem castuje na comparable
    // inaczej wyrzuci wyjątek class cast exception


    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 4, 1, 5, 1, 2, 5, 2, 1, 5, 2, 1, 14, 52, 15, 25, 12, 52, 81, 82);

        Set<Integer> hashSet = new HashSet<>(integerList);
        Set<Integer> treeSet = new TreeSet<>(integerList);


        System.out.println("hash" + hashSet);
        System.out.println("tree" + treeSet);

        // jak zaimplementuje comparable to normalnie można dodawać
        Set<Dog> dogs = new TreeSet<>();
        dogs.add(new Dog("Romek"));
        dogs.add(new Dog("Romek"));
        dogs.add(new Dog("Stefan"));
        dogs.add(new Dog("Romek"));
        dogs.add(new Dog("Adam"));
        System.out.println(dogs);

        // comparator
        Set<Dog> doggs = new TreeSet<>((o1, o2) -> o2.name.compareTo(o1.name));


        NavigableSet<Integer> navigableSet = new TreeSet<>();
        for (int i = 0; i <= 100; i++) {
            navigableSet.add(i);
        }
        /*
            lower - zwraca najwiekszy element ktory jest < e, lub null jesli takiego nie ma
            floor - zwraca najwiekszy element ktory jest <= e, lub null jesli takiego nie ma
            ceiling - zwraca najmniejszy element ktory jest >= e, lub null jesli takiego nie ma
            higher - zwraca najmniejszy element ktory jest > e, lub null jesli takiego nie ma
         */
        System.out.println(navigableSet.lower(50));
        System.out.println(navigableSet.floor(50));
        System.out.println(navigableSet.ceiling(90));
        System.out.println(navigableSet.higher(90));
        System.out.println(navigableSet.ceiling(100));
        System.out.println(navigableSet.higher(100));
    }

    private static class Dog implements Comparable<Dog>{
        private String name;

        public String getName() {
            return name;
        }

        public Dog(String name) {
            this.name = name;
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



        @Override
        public int compareTo(Dog o) {
            return this.name.compareTo(o.name);
        }
    }
}
