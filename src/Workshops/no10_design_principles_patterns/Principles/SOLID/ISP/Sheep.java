package Workshops.no10_design_principles_patterns.Principles.SOLID.ISP;

import Workshops.no10_design_principles_patterns.Principles.SOLID.ISP.Animal;

public class Sheep implements Animal {
    @Override
    public void eat() {
        System.out.println("Sheep eating");
    }

    @Override
    public void move() {
        System.out.println("Sheep moving");
    }

    @Override
    public void haircut() {

    }
}
