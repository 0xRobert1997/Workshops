package Patterns.Structural.Bridge;

import lombok.ToString;

@ToString
public class Red implements Color {
    @Override
    public String apply() {
        return "Color is Red";
    }
}
