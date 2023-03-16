package Behavioral.Template;

public class BrickHouse extends HouseTemplate{
    @Override
    protected void buildFundation() {
        System.out.println("BrickHouse buildFundation");

    }

    @Override
    protected void buildWalls() {
        System.out.println("BrickHouse buildWalls");

    }

    @Override
    protected void makeRoof() {
        System.out.println("BrickHouse makeRoof");

    }

    @Override
    protected void insertWindows() {
        System.out.println("BrickHouse insertWindows");

    }
}
