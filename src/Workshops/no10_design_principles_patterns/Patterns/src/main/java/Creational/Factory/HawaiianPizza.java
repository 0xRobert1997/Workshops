package Workshops.no10_design_principles_patterns.Patterns.Creational.Factory;

public class HawaiianPizza implements Pizza{
    @Override
    public String whatSauce() {
        return "tomato";
    }

    @Override
    public void bake() {
        System.out.println("I am so baking my pineaaple!");
    }

    public void morePineapple() {
        System.out.println("More pineaaple!");
    }
}
