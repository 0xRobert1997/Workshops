package Patterns.Behavioral.ChainOfResponsibility;

public class QualityCheckHandler implements CarHandler{


    @Override
    public void setNextHandler(CarHandler nextHandler) {
    }

    @Override
    public void handle(Car car) {
        // nie wywołuje następnego handlera
        System.out.printf("Checking quality! %n");
    }
}
