package Exercises.zad5_Prototype;

public class Application {

    public static void main(String[] args) throws CloneNotSupportedException {
        Car car1 = new Car("BMW", "M8", "Black");
        Car car2 = (Car) car1.clone();
        print(car1);
        print(car2);
    }
    private static void print(Car car) {
        System.out.printf("%s %s %s%n", car.getModel(), car.getColor(), car.getBrand());
    }

}
