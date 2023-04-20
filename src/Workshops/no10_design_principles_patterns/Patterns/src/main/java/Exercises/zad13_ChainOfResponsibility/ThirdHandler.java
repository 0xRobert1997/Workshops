package Exercises.zad13_ChainOfResponsibility;

public class ThirdHandler implements Handler {

    Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        System.out.println("Third handler is processing request: " + request.getData());

    }
}
