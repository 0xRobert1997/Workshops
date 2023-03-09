package Workshops.no10_design_principles_patterns.Patterns.Creational.Prototype;


public class SteeringWheel implements Cloneable {

    private double diameter;

    public SteeringWheel(double diameter) {
        this.diameter = diameter;
    }

    public SteeringWheel() {
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public static SteeringWheel of(final double diameter) {
        return new SteeringWheel(diameter);
    }

    public SteeringWheel deepCopy() {
        var newSteeringWheel = new SteeringWheel();
        newSteeringWheel.diameter = diameter;
        return newSteeringWheel;
    }

    @Override
    protected SteeringWheel clone() throws CloneNotSupportedException {
        return (SteeringWheel) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SteeringWheel that)) return false;

        return Double.compare(that.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(diameter);
        return (int) (temp ^ (temp >>> 32));
    }

    public double getDiameter() {
        return diameter;
    }
}
