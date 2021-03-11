package service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThreadContextService {
    public void logWithThreadContext(){
        log.info("Hello from ThreadContextService");
    }
}
