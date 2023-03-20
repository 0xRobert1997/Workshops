package Exercises.zad1;

public class Application {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2); // true
        System.out.println(singleton1.getAppName()); //"My App"
        singleton2.setAppName("My App The Second");
        System.out.println(singleton1.getAppName()); // "My App The Second"
        
    }
}



