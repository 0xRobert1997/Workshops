package Workshops.no1_genercis_and_collections.advanced_collections.Exercises;

import java.util.*;

public class ex2 {

    public static void main(String[] args) {

        List<String> inputPeopleList = List.of(
                "Jerzy Kowalski +4800192841",
                "Jan Kowalski +48000192871",
                "Zdzisiek Kowalski +48000192871",
                "Ambro Kowalski +48000192871",
                "Stefan Nawrocki +48000125847",
                "Anna Tomaszewska +48000421458"
        );

        ArrayList<Person> listForMap = new ArrayList<>();

        for (String input : inputPeopleList) {
            listForMap.add(new Person(input));
        }


        Comparator<String> comparator = Comparator.naturalOrder();
        Map<String, List<Person>> phoneBook = new TreeMap<>(comparator);

        for (Person person : listForMap) {
            List<Person> bySurnameList;

            if (!phoneBook.containsKey(person.getSurname())) {
                bySurnameList = new ArrayList<>();
            } else {
                bySurnameList = phoneBook.get(person.getSurname());
            }

            bySurnameList.add(person);
            Collections.sort(bySurnameList);
            phoneBook.put(person.getSurname(), bySurnameList);

            for (Map.Entry<String, List<Person>> stringListEntry : phoneBook.entrySet()) {
                System.out.println(stringListEntry);
            }

        }
    }


    private static class Person implements Comparable<Person> {

        private final String name;
        private final String surname;
        private final String phoneNumber;


        public Person(String input) {

            String[] splitInput = input.split(" ");

            if (splitInput.length == 3) {
                this.name = splitInput[0];
                this.surname = splitInput[1];
                this.phoneNumber = splitInput[2];
            } else {
                throw new RuntimeException("Wrong input: " + input);
            }

        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "[" + name + " " + surname + " " + phoneNumber + ']';
        }

        @Override
        public int compareTo(Person o) {

            int compareBySurname = this.surname.compareTo(o.surname);
            if (compareBySurname != 0) {
                return compareBySurname;
            }

            int compareByName = this.name.compareTo(o.name);
            if (compareByName != 0) {
                return compareByName;
            }
            return 0;
        }
    }
}
