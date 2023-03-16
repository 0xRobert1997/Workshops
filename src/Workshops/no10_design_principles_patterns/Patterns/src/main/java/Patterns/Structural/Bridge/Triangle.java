package Structural.Bridge;

import lombok.ToString;

@ToString(callSuper = true)
public class Triangle extends Shape{

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.println("Triangle with color: " + color.apply());
    }
}
