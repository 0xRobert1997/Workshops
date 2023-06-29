package code;

import java.util.Objects;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Thread myThread0 = new MyThreadImp();

        Runnable myRunnable = new MyThreadRunnableImp();
        Thread myThread1 = new Thread(myRunnable, "my second thread");

        Thread myThread2 = new Thread(() -> System.out.println("hello from lambda"), "my lambda thread");

        // nie odpalać bezpośrednio metody run(), zamiast tego start()
        // jak odpalimy run() to wszystko wykona się w jednym wątku zamiast w dwóch
        myThread0.start();
        myThread1.start();
        myThread2.start();
        System.out.println("Siemanko main");


        System.out.println(myThread0.getName());
        System.out.println(myThread1.getName());
        System.out.println(myThread2.getName());
        System.out.println(Thread.currentThread().getName());

        myThread0.setName("my first thread");
        System.out.println(myThread0.getName());


        try {
            Thread.sleep(5000L);
        } catch (InterruptedException ex) {
            System.err.println("beep boop, something went wrong xd");
        }

        Object ob1 = new Object();
        Object ob2 = new Object();
        synchronized (ob1) {
            synchronized (ob2){

            }
        }

    }
}
