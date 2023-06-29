package code;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    // not thread safe
    // bo występują 2 operacje odczytu i zapisu
    // drugi wątek może odczytać wartość zanim pierwszy ją odczyta co poskutkuje zwiększeniem tylko o 1 zamiast o 2
    private int count1 = 0;
    private void incrementAndPrint1() {
        System.out.print((count1 = count1 + 1) + " ");
    }

    private AtomicInteger count2 = new AtomicInteger(0);
    private void incrementAndPrint2() {
        System.out.print(count2.incrementAndGet() + " ");
    }
}
