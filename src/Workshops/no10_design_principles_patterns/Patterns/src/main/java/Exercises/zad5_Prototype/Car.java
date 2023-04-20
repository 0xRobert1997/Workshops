package Exercises.zad5_Prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car implements Cloneable{
    private String brand;
    private String model;
    private String color;

    public Car clone() {
        Car car = new Car(this.brand, this.model, this.color);
        return car;
    }
}
