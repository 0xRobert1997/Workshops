package code.logger2;

import code.logger1.Logger1;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Slf4j
public class Logger2 {



    public static void log() {
        log.trace("Logging trace message in {}", Logger2.class.getName());
        log.debug("Logging debug message in {}", Logger2.class.getName());
        log.info("Logging info message in {}", Logger2.class.getName());
    }
}
