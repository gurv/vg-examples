package ru.gurv.vg.sample.operation.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OperationGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationGenerator.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private Source source;

    @Autowired
    public OperationGenerator(Source source) {
        this.source = source;
    }

    @Scheduled(fixedRate = 1000)
    public void work() {
        Date now = new Date();
        source.output().send(MessageBuilder.withPayload(now).build());
        LOGGER.info("The time is now {}", dateFormat.format(now));
    }
}
