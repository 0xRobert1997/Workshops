package code;

public class DeadlockExample {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static void main(String[] args) {
        Member1 member1 = new Member1();
        Member2 member2 = new Member2();
        member1.start();
        member2.start();
    }
    private static class Member1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Member 1: Inside lock 1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Member 1: Before lock 2...");
                synchronized (lock2) {
                    System.out.println("Member 1: Inside lock 1 & 2...");
                }
            }
        }
    }
    private static class Member2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Member 2: Inside lock 2...");
            try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Member 2: Before for lock 1...");
                synchronized (lock1) {
                    System.out.println("Member 2: Inside lock 1 & 2...");
                }
            }
        }
    }
}
