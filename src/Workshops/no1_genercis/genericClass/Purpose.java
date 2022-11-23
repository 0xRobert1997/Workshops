package Workshops.no1_genercis_collections.genericClass;

import java.util.ArrayList;
import java.util.List;

public class Purpose {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(2);
        list.add("element");
        list.add(new Purpose());
        print(list);

        List<String> newList = new ArrayList<>();
    }

    private static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            String element = (String) list.get(i);
            System.out.println(element);

        }
    }

}
