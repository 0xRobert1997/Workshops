package Patterns.Behavioral.Template;

public class Main {
    public static void main(String[] args) {

        HouseTemplate houseTemplate1 = new BrickHouse();
        houseTemplate1.build();

        HouseTemplate houseTemplate2 = new WoodenHouse();
        houseTemplate2.build();
    }
}
