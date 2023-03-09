package Workshops.no10_design_principles_patterns.Patterns.Creational.Singleton;

public class StaticBlockSingleton {
    // wersja eager

    private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception thrown while creating instance");
        }
    }

    private StaticBlockSingleton() {
        System.out.println("Calling constructor StaticBlockSingleton");
    }

    public static StaticBlockSingleton getInstance() {
        System.out.println("getInstance() called");
        return instance;
    }

    static void someStaticMethod() {
        System.out.println("Calling someStaticMethod()");
    }
}
