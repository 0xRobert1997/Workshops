package Workshops.no1_genercis.Exercises;

import java.util.List;

public class ex5 {

    public static void main(String[] args) {

        List<Integer> valuesList = List.of(1, 5, 20, 30, 22, 33, 11, 31, 43, 34, 55, 86);
        maxValue(valuesList,1, 5);
    }

    private static <t> void maxValue(List<t> valuesList, t start, t end) {
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
