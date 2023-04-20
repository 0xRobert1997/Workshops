package Workshops.no10_design_principles_patterns.Principles.SOLID;

import Workshops.no10_design_principles_patterns.Principles.SOLID.LSP.Rectangle;
import Workshops.no10_design_principles_patterns.Principles.SOLID.LSP.Square;

public class Main {

    public static void main(String[] args) {

        /*
        Single Responsibility Principle - SRP - klasa powinna mieć jedną, ale to tylko jedną odpowiedzialność

        Open/Closed Principle   - OCP - mówi, że klasy lub obiekty oraz metody powinny być otwarte
                                        na rozszerzanie, ale zamknięte na modyfikacje. (jak kompatybilność wsteczna w javie)

        Liskov Substitution Principle - LSP - kwadrat-prostokąt nie spełnia zasady LSP

        Interface Segregation Principle - ISP - interface powinien zawierać tylko minimalny zestaw metod, które są niezbędne żeby
                                                zapewnić funkcjonalność. -animal -> fish/sheep
        Dependency Inversion Principle - DIP - bezpieczniej zależeć od interface'u niż konretnej implementacji


            IoC - Inversion of Control
            DI - Dependency Injection
            IOC Container
         */


        // LSP
        Rectangle rectangle = new Square(10);
        rectangle.setA(2);
        rectangle.setB(4);
        System.out.println(rectangle.area());
        // otrzymamy 16 bo kwadrat nadpisał settery



    }
}
