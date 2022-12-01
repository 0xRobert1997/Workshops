package Workshops.no1_genercis.Exercises;

import java.util.ArrayList;
import java.util.List;

public class ex4 {

    public static void main(String[] args) {

        List<String> mylist = new ArrayList<>();
        mylist.add("elem1");
        mylist.add("elem2");
        mylist.add("elem3");
        mylist.add("elem4");
        mylist.add("elem5");

        swapMethod(mylist, 2, 3);
    }

    private static <t> void swapMethod(List<t> mylist, int firstPosition, int secondPosition) {
        t temp1 = mylist.get(firstPosition);
        t temp2 = mylist.get(secondPosition);

        t temp3 = temp1;

        temp1 = temp2;
        temp2 = temp3;

        mylist.set(firstPosition, temp1);
        mylist.set(secondPosition, temp2);

        System.out.println(mylist);

    }
}
