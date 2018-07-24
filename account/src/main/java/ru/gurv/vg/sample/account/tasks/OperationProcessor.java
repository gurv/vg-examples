package ru.gurv.vg.sample.account.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OperationProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationProcessor.class);

    @StreamListener(Sink.INPUT)
    public void handle(String msg) {
        LOGGER.info("OperationProcessor... {}", msg);
    }
}
