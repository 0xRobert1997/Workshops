package Workshops.no1_genercis.Exercises;

import java.util.List;
import java.util.function.Predicate;

public class ex3 {

    public static void main(String[] args) {

        List<Integer> myList = List.of(1,2,3,4,5,6,7,8,9,10,15,20,25,30,40,50);

        filter(myList, e -> {
            if ((e % 2) == 0) {
                return true;
            } else {
                return false;
            }
        }
        );

    }

    private static <t> void filter(List<t> list, Predicate<t> checker) {
        int counter = 0;
        for (t element : list) {
            if (checker.test(element)) {
                counter++;
            }
        }
        System.out.println(counter);
    }


}
