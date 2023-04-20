package Exercises.zad14_Observer;

import java.util.ArrayList;

public class WeatherStation {

    private ArrayList<Display> listOfObservers;

    public WeatherStation(ArrayList arrayList) {
        this.listOfObservers = arrayList;
    }

    public void registerObserver(Display display) {
        listOfObservers.add(display);
    }

    public void setMeasurements(int i, int i1, float v) {
        for (Display observer : listOfObservers) {
            observer.update("new data: " + i + " " + i1 + " " + v);
        }
    }

    public void removeObserver(Display display) {
        listOfObservers.remove(display);
    }
}
