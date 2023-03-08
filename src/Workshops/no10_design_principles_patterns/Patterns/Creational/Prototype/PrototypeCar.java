package Workshops.no10_design_principles_patterns.Patterns.Creational.Prototype;

import java.util.Objects;

public class CopyCar {

    // shallow copy
    // deep copy

    private SteeringWheel steeringWheel;

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public CopyCar shallowCopy() {
        var newCar = new CopyCar();
        newCar.steeringWheel = steeringWheel;
        return newCar;
    }

    public CopyCar deepCopy() {
        var newCar = new CopyCar();
        newCar.steeringWheel = this.steeringWheel.deepCopy();
        return newCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CopyCar copyCar)) return false;

        return Objects.equals(steeringWheel, copyCar.steeringWheel);
    }

    @Override
    public int hashCode() {
        return steeringWheel != null ? steeringWheel.hashCode() : 0;
    }
}
