package code;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    void someMethod() {
        LOGGER.log(Level.INFO, "some message to log");
    }

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "some message");
        LOGGER.log(Level.WARNING, "warning message");
    }
}
