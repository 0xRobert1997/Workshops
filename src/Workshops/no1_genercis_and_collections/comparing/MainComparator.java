package Workshops.no1_genercis_and_collections.comparing;

import java.util.*;

public class Comparator {

//     compare zwraca
//     liczba ujemna jeśli o1 > o2
//      0 jeśli o1 = o2
//      liczba dodatnia jeśli o1 < o2

    // compare powinno byc spojne z equals()

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "A", "1", "X", "aA", "Aa", "A1", "B1", "b2");
        System.out.println(strings);
        java.util.Comparator<String> myComparator = java.util.Comparator.<String>naturalOrder().reversed();
        strings.sort(myComparator);
        System.out.println(strings);


        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "Roman"));
        cats.add(new Cat(6, "Zbyszek"));
        cats.add(new Cat(3, "Rafał"));
        cats.add(new Cat(2, "Stefan"));
        cats.add(new Cat(5, "Roman"));
        cats.add(new Cat(4, "Roman"));
        cats.add(null);
        System.out.println(cats);


        //klasa anonimowa
        java.util.Comparator<Cat> myFirstComparator = new java.util.Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }.thenComparing(new java.util.Comparator<Cat>() {
            // jeśli jakieś koty bd mieć takie samo imię to dodatkowo porównuje id
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getId() - o2.getId();
            }
        });
        //cats.sort(myFirstComparator.reversed());

        java.util.Comparator<Cat> mySecondComparator = new java.util.Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1 == null){
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                int result =  o1.getName().compareTo(o2.getName());
                if (result != 0) {
                    return result;
                }
                return o1.getId() - o2.getId();
            }
        };
        cats.sort(mySecondComparator.reversed());

        java.util.Comparator<Cat> myThirdComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        myThirdComparator = myThirdComparator.thenComparing((o1, o2) -> o1.getId() - o2.getId());

        cats.sort(myThirdComparator);



    }
}
