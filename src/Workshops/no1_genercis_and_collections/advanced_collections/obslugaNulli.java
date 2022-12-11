package Workshops.no1_genercis_and_collections.advanced_collections;

import java.util.*;

public class obslugaNulli {
    /*
        NullPointer wyskakuje gdy dodamy null w
            -TreeMap, hashtable, TreeSet, queue

            w hashMap/linkedHashMap kluczami może być null
     */

    public static void main(String[] args) {

        Set<Integer> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1 == null || o2 == null) {
                return 0;
            }
            return o1 - o2;
        });
        treeSet.add(1);
        treeSet.add(null);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(2);
        System.out.println(treeSet);
        // przy takiej obsludze nie wyrzuca wyjatku i nie drukuje nulli

        Comparator<Integer> myComparator = Comparator.nullsFirst(Comparator.naturalOrder());
        Comparator<Integer> myComparator2 = Comparator.nullsLast(Comparator.naturalOrder());

    }
}
