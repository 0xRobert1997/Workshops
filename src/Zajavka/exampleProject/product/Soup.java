package Zajavka.exampleProject.product;

import Zajavka.exampleProject.person.ConsumingMan;
import Zajavka.exampleProject.person.ProducingMan;

public class Soup extends Food {
    public Soup(String name, ProducingMan producingMan, ConsumingMan consumingMan) {
        super(name, producingMan, consumingMan);
    }
}
