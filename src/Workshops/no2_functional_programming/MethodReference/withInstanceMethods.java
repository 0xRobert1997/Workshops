package Workshops.no2_functional_programming.MethodReference;

import java.util.Optional;

public class withInstanceMethods {

    public static void main(String[] args) {
        withInstanceMethods withInstanceMethods = new withInstanceMethods();
        withInstanceMethods.run();

    }


    private void run() {

        DogPrinter dogPrinter = new DogPrinter();

        String someDog = Optional.of(new Dog("Burek"))
                .map(Dog::dejNejm)
                .orElse("anotherDogName");
        System.out.println(someDog);

        Optional.of(new Dog("next Burek"))
                .ifPresent(System.out::println);

        Optional.of(new Dog("next Burek"))
                .ifPresent(dogPrinter::printDoggy);

    }

    static void printDoggy(final Dog dog) {
        System.out.println(dog);
    }

    static class DogPrinter {
        private void printDoggy(final Dog dog) {
            System.out.println(dog);
        }
    }


}
