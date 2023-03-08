package Workshops.no10_design_principles_patterns.Patterns.Singleton;

public class LazyInitializationSingleton {

    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {
        System.out.println("Creating LazyInitializationSingleton");
    }

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }

    static void someStaticMethod() {
        System.out.println("Calling someStaticMethod()");
    }
}
