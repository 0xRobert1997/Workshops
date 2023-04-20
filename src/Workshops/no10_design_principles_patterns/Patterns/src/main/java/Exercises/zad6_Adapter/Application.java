package Exercises.zad6_Adapter;

public class Application {

    // Adapter - implementuje docelowy interface który jest oczekiwany przez klienta
    // Adaptee - klasa którą chcemy dopasować
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}
