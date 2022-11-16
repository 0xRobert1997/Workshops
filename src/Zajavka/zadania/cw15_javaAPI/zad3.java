package Zajavka.zadania.cw15_javaAPI;

import java.math.BigInteger;

public class zad3 {

    // silnia
    public static void main(String[] args) {
        BigInteger myBI =  BigInteger.valueOf(20);

        strong(myBI);
    }

    private static void strong(BigInteger myBI) {
        int checker = myBI.intValue();

        for (int i = 1; i < checker; i++) {
            myBI = myBI.multiply(BigInteger.valueOf(i));
        }
        System.out.println(myBI);
    }
}
