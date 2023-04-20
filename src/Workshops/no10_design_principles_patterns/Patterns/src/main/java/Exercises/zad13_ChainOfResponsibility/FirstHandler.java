package Exercises.zad13_ChainOfResponsibility;

public class FirstHandler implements Handler{
    Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        System.out.println("First handler is processing request: " + request.getData());
        nextHandler.handleRequest(request);
    }
}
