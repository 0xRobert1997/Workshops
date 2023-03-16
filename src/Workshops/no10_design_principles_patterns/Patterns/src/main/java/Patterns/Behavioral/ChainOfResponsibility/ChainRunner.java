package Behavioral.ChainOfResponsibility;

import java.util.List;

public class ChainRunner {

    private final CarHandler carHandler;

    public ChainRunner() {
        this.carHandler = new CabrioletHandler();
        CarHandler handler2 = new JeepHandler();
        CarHandler handler3 = new ColorHandler();
        CarHandler handler4 = new EquipmentHandler();

        CarHandler handler5 = new QualityCheckHandler();

        carHandler.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);
        handler4.setNextHandler(handler5);
        handler5.setNextHandler(null);
    }

    public static void main(String[] args) {

        // handler
        // concrete handler

        ChainRunner chainRunner = new ChainRunner();
          chainRunner.carHandler.handle(Car.of(Car.Type.CABRIOLET, "Blue", List.of("Steering wheel")));
  //      chainRunner.carHandler.handle(Car.of(Car.Type.JEEP, "Black", List.of("Wheels")));
    //  chainRunner.carHandler.handle(Car.of(Car.Type.CABRIOLET, "Red", null));

    }
}
