import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.junit.Test;

public class TestLogLevels {
    Logger log = LogManager.getLogger(TestLogLevels.class);

    @Test
    public void testLogLevels(){ // стандартные логи с приоритетом
        // чем меньше число тем выше приоритет
        log.fatal("fatal"); //100
        log.error("error"); //200
        log.warn("warn"); //300
        log.info("info"); //400
        log.debug("debug"); //500
        log.trace("trace"); //600


        Level VERBOSE = Level.forName("VERBOSE", 250); // свой уровень логирования
        log.log(VERBOSE,"a verbose message"); // передача метода со своим уровнем приоритета

    }

}
