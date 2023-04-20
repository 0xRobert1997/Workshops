package Patterns.Structural.Bridge;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public abstract class Shape {

    protected Color color;

    public abstract void applyColor();

}
