package Workshops.no1_genercis_and_collections;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Map<String, Double> map = new HashMap<>();
        map.put("a", 1.2);
        System.out.println(map.getOrDefault("d", null).toString());
    }
}
