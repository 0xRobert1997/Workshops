package Workshops.no2_functional_programming.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class podsumowanie {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
         integerList.add(1);
         integerList.add(2);
         integerList.add(3);
         integerList.add(3);
         integerList.add(9);

         Set<Integer> mySet = integerList.stream()
                 .collect(
                         () -> new TreeSet<>(),
                         (currentSet, nextElem) -> currentSet.add(nextElem),
                         (firstSet, secondSet) -> firstSet.addAll(secondSet)
                 );

         Integer result = integerList.stream()
                 .reduce(0, (currentState, nextValue) -> currentState + nextValue);
         //                     ^ jak tu nie będzie 1 argumentu (identity) to spodziewa się że wynikiem będzie optional
    }
}
