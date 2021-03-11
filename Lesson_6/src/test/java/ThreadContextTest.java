import service.ThreadContextService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.junit.Test;

@Log4j2
public class ThreadContextTest {

        private final ThreadContextService service = new ThreadContextService();
        @Test
        public void testThreadContext(){

            ThreadContext.put("ip", "192.168.0.1"); // как номер ip потока
            ThreadContext.put("user", "Smith"); // имя пользователя

            log.info("Hello from logs.logtests.ThreadContextTest"); // Выводим из этого потока
            service.logWithThreadContext(); // выводим из потока ThreadContextService

            ThreadContext.clearAll(); // чистим поток (thread)

            log.info("Hello from logs.logtests.ThreadContextTest again"); //  и тут выводится уже без ip и имени
        }

}
