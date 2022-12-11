package Workshops.no1_genercis_and_collections.generics.Exercises;

import java.util.List;

public class ex5 {

    public static void main(String[] args) {

        List<Integer> valuesList = List.of(1, 5, 20, 30, 22, 33, 11, 31, 43, 34, 55, 86);
        maxValue(valuesList,2, 5);
    }

    private static <T extends Number> void maxValue(List<T> valuesList, T start, T end) {
        int max = (int)start;
        int x = (int) start;
        int y = (int) end;

        for (int i = x; i <= y; i++) {
            int toComapre = (int)valuesList.get(i);
            if (toComapre > max) {
                max = toComapre;
            }

        }
        System.out.println(max);
    }
}
