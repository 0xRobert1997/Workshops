package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.ex1;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ex1 {

    public static void main(String[] args) {

        NavigableSet<Car> firstSet = new TreeSet<>();
        firstSet.add(new Car("BMW", "x2", 1222));
        firstSet.add(new Car("KKK", "x3", 1999));
        firstSet.add(new Car("ABW", "x69", 1337));
        firstSet.add(new Car("CBS", "x5", 2000));
        firstSet.add(new Car("PDW", "x1", 2137));

        NavigableSet<Car> secondSet = new TreeSet<>();
        firstSet.add(new Car("JD", "x7", 7312));
        firstSet.add(new Car("KKK", "x3", 1999));
        firstSet.add(new Car("PVM", "x8", 1333));
        firstSet.add(new Car("ABW", "x69", 1337));
        firstSet.add(new Car("DD", "x9", 1420));

        NavigableSet<Car> thirdSet = new TreeSet<>(firstSet);
        thirdSet.addAll(secondSet);

        System.out.println(thirdSet);

    }

    private static class Car implements Comparable<Car>{
        private final String brand;
        private final String model;
        private final Integer year;


        public Car(String brand, String model, Integer year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public Integer getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "["+ brand +  ", " + model + ", " + year + "]";
        }


        @Override
        public int compareTo(Car o) {

            int comparebyBrand = this.brand.compareTo(o.brand);
            if (comparebyBrand != 0) {
                return comparebyBrand;
            }

            int compareByModel = this.model.compareTo(o.model);
            if (compareByModel != 0) {
                return compareByModel;
            }
            int compareByYear = this.year.compareTo(o.year);
            if (compareByYear != 0) {
                return compareByYear;
            }

            return 0;
        }
    }
}
