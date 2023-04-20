package Patterns.Structural.Bridge;

import lombok.ToString;

@ToString
public class Green implements Color{
    @Override
    public String apply() {
        return "Color is Green";
    }
}
