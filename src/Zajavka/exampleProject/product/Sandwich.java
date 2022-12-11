package Zajavka.exampleProject.product;

import Zajavka.exampleProject.person.ConsumingMan;
import Zajavka.exampleProject.person.ProducingMan;

public class Sandwich extends Food {
    public Sandwich(String name, ProducingMan producingMan, ConsumingMan consumingMan) {
        super(name, producingMan, consumingMan);
    }
}
