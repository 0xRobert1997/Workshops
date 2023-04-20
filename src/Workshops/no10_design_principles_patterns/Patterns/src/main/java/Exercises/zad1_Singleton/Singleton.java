package Exercises.zad1_Singleton;

import lombok.Data;

@Data
public class Singleton {

    private static Singleton instance;
    private String AppName;

    static {
        instance = new Singleton();
        instance.AppName = "My App";
    }

    public static Singleton getInstance() {
        return instance;
    }
}
