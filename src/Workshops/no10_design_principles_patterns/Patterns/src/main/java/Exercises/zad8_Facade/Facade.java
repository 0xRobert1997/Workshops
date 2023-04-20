package Exercises.zad8_Facade;

public class Facade {

    ComplexSystem complexSystem;

    public Facade(ComplexSystem complexSystem) {
        this.complexSystem = complexSystem;
    }

    public void simpleOperation() {
        System.out.println("Performing simple operation using: " + this.complexSystem);
        this.complexSystem.method1();
    }

    public void complexOperation() {
        System.out.println("Performing complex operation using: " + this.complexSystem);
        this.complexSystem.method1();
        this.complexSystem.method2();
        this.complexSystem.method3();
    }
}
