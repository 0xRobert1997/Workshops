package Behavioral.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColorHandler implements CarHandler{

    private CarHandler nextHandler;

    @Override
    public void setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Car car) {
        if (Objects.nonNull(car.getColor())) {
            System.out.printf("Preparing %s color %n", car.getColor());
            // nie wywołuje następnego handlera
        } else {
            this.nextHandler.handle(car);
        }
    }
}
