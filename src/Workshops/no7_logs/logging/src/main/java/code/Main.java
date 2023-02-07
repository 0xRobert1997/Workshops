package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        log.trace("hello, parametrL {}", 123);
        log.debug("hello, parametrL {}", 234);
        log.info("hello, parametrL {}", 345);
        log.warn("hello, parametrL {}", 456);
        log.error("hello, parametrL {}", 567);
    }
}
