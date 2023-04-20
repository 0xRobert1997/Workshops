package code;

import code.logger1.Logger1;
import code.logger2.Logger2;
import code.loggerloop.LoggerLoop;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

@Slf4j
// zmienna do logowania wygenerowana przez lomboka nazywa się log
public class Main {

 //   private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

            log.trace("Logging trace message in {}", Main.class.getName());
            log.debug("Logging debug message in {}", Main.class.getName());
            log.info("Logging info message in {}", Main.class.getName());
            log.warn("Logging warn message in {}", Main.class.getName());
            log.error("Logging error message in {}", Main.class.getName());

            Logger1.log();
            Logger2.log();


        LoggerLoop.log();
    }
}
