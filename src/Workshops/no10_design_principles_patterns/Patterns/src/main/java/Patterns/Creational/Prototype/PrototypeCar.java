package Patterns.Creational.Prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PrototypeCar implements Cloneable {

    // shallow copy
    // deep copy

    private String brand;
    private String model;
    private SteeringWheel steeringWheel;
    private List<String> doors;


    @Override
    protected PrototypeCar clone() throws CloneNotSupportedException {
        final PrototypeCar cloned = (PrototypeCar) super.clone();
        cloned.brand = brand;
        cloned.model = model;
        cloned.steeringWheel = this.steeringWheel.clone();
        cloned.doors = new ArrayList<>(this.doors);
        return cloned;
    }

/*    public PrototypeCar shallowCopy() {
        var newCar = new PrototypeCar();
        newCar.steeringWheel = steeringWheel;
        return newCar;
    }

    public PrototypeCar deepCopy() {
        var newCar = new PrototypeCar();
        newCar.steeringWheel = this.steeringWheel.deepCopy();
        return newCar;
    }*/

    public PrototypeCar() {
        this.brand = "Ford";
        this.model = "Mustang";
        this.steeringWheel = SteeringWheel.of(10.65);
        this.doors = new ArrayList<>(Arrays.asList("lf", "rf", "lf", "rr"));
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrototypeCar prototypeCar)) return false;

        return Objects.equals(steeringWheel, prototypeCar.steeringWheel);
    }

    @Override
    public int hashCode() {
        return steeringWheel != null ? steeringWheel.hashCode() : 0;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public List<String> getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "PrototypeCar{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", steeringWheel=" + steeringWheel +
                ", doors=" + doors +
                '}';
    }
}
