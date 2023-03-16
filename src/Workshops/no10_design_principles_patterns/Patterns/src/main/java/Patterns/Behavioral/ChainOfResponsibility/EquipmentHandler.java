package Behavioral.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentHandler implements CarHandler{

    private CarHandler nextHandler;

    @Override
    public void setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Car car) {
        if (Objects.nonNull(car.getEquipment())) {
            System.out.printf("Preparing equipment: %s %n", car.getEquipment());
            // nie wywołuje następnego handlera
        } else {
            this.nextHandler.handle(car);
        }
    }
}
