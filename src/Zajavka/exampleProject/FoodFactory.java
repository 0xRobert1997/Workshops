package Zajavka.exampleProject;

import Zajavka.exampleProject.person.Consumer;
import Zajavka.exampleProject.person.ConsumingMan;
import Zajavka.exampleProject.person.Producer;
import Zajavka.exampleProject.person.ProducingMan;
import Zajavka.exampleProject.product.Food;

public class FoodFactory {
    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();
        foodFactory.run();
    }

    private void run() {
        ProducingMan[] producingPeople = new ProducingMan[] {
                new Producer("Alicja", "Zupowa"),
                new Producer("Krzysztof", "Ciastkarski")
        };

        ConsumingMan[] consumingPeople = new ConsumingMan[] {
                new Consumer("Rafał", "Pożeracz", "chocolate"),
                new Consumer("Angelika", "Zajadacz", "fish"),
        };

        int counter = 0;
        for (ProducingMan producingPerson : producingPeople) {
            for (ConsumingMan consumingPerson : consumingPeople) {
                counter++;
            }
        }

        Food[] foods = new Food[counter];

        int index = 0;
        for (ProducingMan producingPerson : producingPeople) {
            for (ConsumingMan consumingPerson : consumingPeople) {
                Food food = producingPerson.produce(consumingPerson.getExpectations(), consumingPerson);
                foods[index] = food;
                index++;
            }
        }

        System.out.println("PRINTING FOOD");
        for (Food food : foods) {
            System.out.println(food);
            
        }
    }
}
