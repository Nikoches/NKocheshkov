package ru.job4j;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class Log4java {
    private static final Logger LOG = LogManager.getLogger(Log4java.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }

}
