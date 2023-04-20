package Patterns.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsTopic implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void reigster(Observer observer) {
        if (Objects.isNull(observer)) {
            throw new NullPointerException("Observer is null");
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void setNews(String message) {
        System.out.println("Message posted: " + message);
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
