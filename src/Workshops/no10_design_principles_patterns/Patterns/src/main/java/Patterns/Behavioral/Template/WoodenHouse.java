package Behavioral.Template;

public class WoodenHouse extends HouseTemplate{
    @Override
    protected void buildFundation() {
        System.out.println("WoodenHouse buildFundation");

    }

    @Override
    protected void buildWalls() {
        System.out.println("WoodenHouse buildWalls");

    }

    @Override
    protected void makeRoof() {
        System.out.println("WoodenHouse makeRoof");

    }

    @Override
    protected void insertWindows() {
        System.out.println("WoodenHouse insertWindows");

    }
}
