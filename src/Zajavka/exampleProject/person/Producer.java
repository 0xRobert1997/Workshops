package Zajavka.exampleProject.person;

import Zajavka.exampleProject.product.Chocolate;
import Zajavka.exampleProject.product.Food;
import Zajavka.exampleProject.product.Sandwich;
import Zajavka.exampleProject.product.Soup;

public class Producer extends Person implements ProducingMan{

    public Producer(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String getExpectations() {
        return "no expectations";
    }

    // trzeba dodać public bo nie można zawężać, wcześniej domyślnie było public abstract a teraz
    // jakbyśmy nic nie wpisali byłoby default
    // dlatego zawsze jak implementujemy metodę z interfejsu yo musi byc public
    @Override
    public void consume(Food food) {
        System.out.println("Producent consuming food: " + food);

    }

    @Override
    public Food produce(String productName, ConsumingMan consumingMan) {
        switch(productName) {
            case "chocolate":
                return new Chocolate(productName,this, consumingMan);
            case "soup":
                return new Soup(productName,this, consumingMan);
            default:
                return new Sandwich(productName,this, consumingMan);
        }
    }
}
