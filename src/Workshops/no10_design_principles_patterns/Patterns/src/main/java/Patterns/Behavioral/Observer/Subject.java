package Behavioral.Observer;



public interface Subject {

    void reigster(Observer observer);

    void unregister(Observer observer);
}
