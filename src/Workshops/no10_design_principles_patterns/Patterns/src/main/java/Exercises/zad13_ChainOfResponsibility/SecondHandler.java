package Exercises.zad13_ChainOfResponsibility;

public class SecondHandler implements Handler{

    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        System.out.println("Second handler is processing request: " + request.getData());
        nextHandler.handleRequest(request);
    }
}
