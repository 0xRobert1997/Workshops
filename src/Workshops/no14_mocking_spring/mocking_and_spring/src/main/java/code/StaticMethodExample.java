package code;

import java.time.LocalTime;

public class StaticMethodExample {

    public int getNano() {
        LocalTime now = getNow();
        return now.getNano();
    }
// wrapujemy metodę statyczną Local.now() metodą instancyjną getNow()
    public LocalTime getNow() {
        return LocalTime.now();
    }
}
