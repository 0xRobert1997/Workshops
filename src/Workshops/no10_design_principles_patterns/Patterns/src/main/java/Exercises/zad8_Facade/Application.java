package Exercises.zad8_Facade;

public class Application {

    public static void main(String[] args) {
        Facade facade = new Facade(new ConcreteComplexSystem());
        facade.simpleOperation();
        facade.complexOperation();
    }
}

/*
Performing a simple operation using the complex system
Method 1 from complex system
Performing a complex operation using the complex system
Method 1 from complex system
Method 2 from complex system
Method 3 from complex system
 */