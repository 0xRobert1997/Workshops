package Patterns.Behavioral.Template;

public abstract class HouseTemplate {

    protected final void build() {
        digHole();
        buildFundation();
        buildWalls();
        makeRoof();
        insertWindows();
    }

    protected void digHole() {
        System.out.println("Digging hole");
    }
    protected  abstract void buildFundation();
    protected  abstract void buildWalls();
    protected  abstract void makeRoof();
    protected  abstract void insertWindows();
}
