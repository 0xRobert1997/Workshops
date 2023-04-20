package Patterns.Structural.Decorator;

public class Main {

    public static void main(String[] args) {

        CarImpl originalCar = new CarImpl();
  /*      System.out.println(originalCar.create());

        Car car1 = new SpoilerDecorator(new CarImpl());
        System.out.println(car1.create());

        Car car2 = new NeonDecorator(new CarImpl());
        System.out.println(car1.create());*/

/*        Car car4 =
                new SpoilerDecorator(
                        new RimsDecorator(
                                new NeonDecorator(
                                        new CarImpl())));
        System.out.println(car4.create());*/


        Car car1 = () -> "Before Car! " + originalCar.create() + " with Spoiler";
        Car car2 = () -> "Before Car! " + originalCar.create() + " with Rims with Spoiler";
        Car car3 = () -> "Before Car! " + originalCar.create() + " with Spoiler with Neon";

        System.out.println(car1.create());
    }
}


