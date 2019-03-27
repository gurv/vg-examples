package ru.gurv.vg.sample.operation.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import ru.gurv.vg.sample.operation.domain.Operation;

@Component
public class OperationRepositoryEventListener extends AbstractRepositoryEventListener<Operation> {

    private final Logger logger = LoggerFactory.getLogger(OperationRepositoryEventListener.class);

    @Override
    public void onBeforeSave(Operation operation) {
        logger.info("#handleBeforeSave: Operation {}", operation);
    }

    @Override
    public void onAfterSave(Operation operation) {
        logger.info("#handleAfterSave: Operation {}", operation);
    }
}
