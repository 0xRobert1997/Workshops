package Exercises.zad6_Adapter;

public class Adapter implements Target{

    Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void request() {
        System.out.println("Method called");
    }
}
