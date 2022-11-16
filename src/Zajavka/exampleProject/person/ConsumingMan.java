package Zajavka.exampleProject.person;

import Zajavka.exampleProject.product.Food;

public interface ConsumingMan {
    // domyślnie jest public abstract
    void consume(Food food);

    String getExpectations();
}
