package ru.gurv.vg.sample.operation.projection;

import org.springframework.data.rest.core.config.Projection;
import ru.gurv.vg.sample.operation.domain.Operation;

import java.util.Date;

@Projection(name = "excerpt", types = Operation.class)
public interface OperationExcerpt {

    Long getId();

    Date getTs();
}
