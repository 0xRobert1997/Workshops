package Structural.Decorator;

public class CarImpl implements Car{
    @Override
    public String create() {
        System.out.println("Calling car constructor");
        return "car";
    }
}
