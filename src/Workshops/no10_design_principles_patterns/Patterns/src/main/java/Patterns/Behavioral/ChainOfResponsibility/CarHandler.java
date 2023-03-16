package Behavioral.ChainOfResponsibility;

public interface CarHandler {

    void setNextHandler(CarHandler nextHandler);

    void handle(Car car);
}
