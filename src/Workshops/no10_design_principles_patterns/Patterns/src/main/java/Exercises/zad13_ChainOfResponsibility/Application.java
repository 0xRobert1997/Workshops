package Exercises.zad13_ChainOfResponsibility;

public class Application {

    public static void main(String[] args) {
        Request request = new Request("Some data to process");
        FirstHandler firstHandler = new FirstHandler();
        SecondHandler secondHandler = new SecondHandler();
        ThirdHandler thirdHandler = new ThirdHandler();
        firstHandler.setNextHandler(secondHandler);
        secondHandler.setNextHandler(thirdHandler);
        firstHandler.handleRequest(request);
    }
}
