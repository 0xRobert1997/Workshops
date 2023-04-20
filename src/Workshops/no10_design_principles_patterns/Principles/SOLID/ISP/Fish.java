package Workshops.no10_design_principles_patterns.Principles.SOLID.ISP;

import Workshops.no10_design_principles_patterns.Principles.SOLID.ISP.Animal;

public class Fish implements Animal {
    @Override
    public void eat() {
        System.out.println("Fish eating");
    }

    @Override
    public void move() {
        System.out.println("Fish moving");
    }

    @Override
    public void haircut() {

    }
}
