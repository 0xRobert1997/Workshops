package Exercises.zad2_Factory;

import lombok.Data;

@Data
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
