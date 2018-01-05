package org.demo.log4j;

import java.text.SimpleDateFormat;
import java.util.Date;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    protected static final Logger logger = Logger.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        logger.info("The time is now {}" + dateFormat.format(new Date()));
    }
}
