package Workshops.no1_genercis.Unbounded_Wildcards;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcardsMain {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Java java learning!");

        List<Tuna> tunas = new ArrayList<>();
        tunas.add(new Tuna());

        // print(strings);
        // print(tunas);

        List<?> elements = tunas;
        // nie zadziała V
        // elements.add("new element?");
        System.out.println(elements.get(0));
    }

    // w sumie można i tak zapisać
/*
    private static void print(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
*/
// tu użycie unbounded wildcardsów
    private static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }


    static class Tuna {

    }
}
