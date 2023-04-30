package code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {


        log.trace("Logging trace message in {}", Main.class.getName());
        log.debug("Logging debug message in {}", Main.class.getName());
        log.info("Logging info message in {}", Main.class.getName());
        log.warn("Logging warn message in {}", Main.class.getName());
        log.error("Logging error message in {}", Main.class.getName());
    }
}
