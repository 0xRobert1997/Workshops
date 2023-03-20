
package Patterns.Creational.Builder;
public class Main {

    public static void main(String[] args) {


        Car car = Car.builder()
                .brand("something")
                .model("kek")
                .year("1337")
                .build();

        System.out.println(car);
    }
}
