package Workshops.no2_functional_programming.Exercises;

import java.util.function.BiFunction;

public class ex1 {

    public static void main(String[] args) {

        BiFunction<Integer, Double, String> biFunctionImp = ex1::exerciseImplementation;

        String result = biFunctionImp.apply(420, 6.9);
        System.out.println(result);
    }

    static String exerciseImplementation(Integer a, Double b) {
        System.out.println("Integer arg: " + a);
        System.out.println("Double arg: " + b);
        return "String : " + a.toString() + " " + b.toString();
    }
}
