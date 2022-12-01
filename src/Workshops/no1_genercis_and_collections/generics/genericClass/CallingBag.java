package Workshops.no1_genercis.genericClass;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CallingBag {

    public static void main(String[] args) {
/*        Bag<String> bag = new Bag<>();
        System.out.println(bag);
        bag.pack("string element");
        System.out.println(bag);
        String empty = bag.empty();
        System.out.println(bag);

        Bag<Car> carBag = new Bag<>();
        System.out.println(carBag);
        carBag.pack(new Car());
        System.out.println(carBag);
        Car emptyCar = carBag.empty();
        System.out.println(carBag);


        List<Car> cars = new ArrayList<>();*/
        // cars.add(new SUV());

        CallFilteringBag();
    }

    private static void CallFilteringBag() {
        Car car = new Car("red", 2020);
        FilteringBag<Car, Predicate<Car>, Predicate<Car>> filteringBag = new FilteringBag<>(
                c -> c.getColor().equals("red"),
                c -> c.getYear().equals(2020)
        );
    }

    static class Car {
        private String color;
        private int year;

        public Car(String color, int year) {
            this.color = color;
            this.year = year;
        }

        public String getColor() {
            return color;
        }

        public Integer getYear() {
            return year;
        }
    }


}
