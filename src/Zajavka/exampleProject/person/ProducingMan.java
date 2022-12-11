package Zajavka.exampleProject.person;

import Zajavka.exampleProject.product.Food;

public interface ProducingMan {

    // wszystkie klasy w interfejsie domyślnie sa public abstract
    Food produce(String productName, ConsumingMan consumingMan);

}
