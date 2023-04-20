package Exercises.zad13_ChainOfResponsibility;

public interface Handler {

    void setNextHandler(Handler nextHandler);

    void handleRequest(Request request);
}
