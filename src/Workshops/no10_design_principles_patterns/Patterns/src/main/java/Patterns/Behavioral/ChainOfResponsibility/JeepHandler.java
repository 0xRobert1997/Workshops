package Behavioral.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class JeepHandler implements CarHandler{

    private CarHandler nextHandler;

    @Override
    public void setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Car car) {
        if (Car.Type.JEEP.equals(car.getType())) {
            System.out.println("Preparing Jeep Skeleton");
            final List<String> JeepEquipment = new ArrayList<>(car.getEquipment());
            JeepEquipment.add("Spare wheel");
            this.nextHandler.handle(car.withEquipment(JeepEquipment));
        } else {
            this.nextHandler.handle(car);
        }
    }
}
