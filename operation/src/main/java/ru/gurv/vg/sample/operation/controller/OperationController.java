package ru.gurv.vg.sample.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gurv.vg.sample.operation.domain.Operation;
import ru.gurv.vg.sample.operation.projection.OperationExcerpt;
import ru.gurv.vg.sample.operation.repository.OperationRepository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

@RestController
@Scope("singleton")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {

    @Autowired
    private ProjectionFactory projectionFactory;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private PagedResourcesAssembler<OperationExcerpt> assembler;

    private Boolean processingStarted = false;

    @GetMapping("/ping")
    String ping() {
        return "pong";
    }

    @RequestMapping(value="/operations", method = RequestMethod.GET, produces = "application/hal+json")
    public ResponseEntity<?> getOperations(Pageable pageable) {
        Page<Operation> operations = operationRepository.findAll(pageable);
        Page<OperationExcerpt> projected = operations
                .map(l -> projectionFactory.createProjection(OperationExcerpt.class, l));
        PagedResources<Resource<OperationExcerpt>> resources = assembler.toResource(projected);
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/operations/operation")
    public Page<?> listOperations(Pageable pageable) {
        return operationRepository
                .findAll(pageable)
                .map(operation -> projectionFactory.createProjection(OperationExcerpt.class, operation));
    }

    @RequestMapping(value = "/operations/createOperationBatch")
    public void createOperationBatch() {
        Long batchSize = 100L; //TODO входной параметр метода
        Clock clock = Clock.system(ZoneId.of("UTC"));
        Stream.iterate(0, i -> i + 1).limit(batchSize).forEach(i -> {
            Operation operation = new Operation();
            operation.setTs(LocalDateTime.now(clock));
            operationRepository.save(operation);
        });
    }

    @RequestMapping(value = "/operations/startProcessing")
    public void startProcessing() {
        processingStarted = true;
    }

    @RequestMapping(value = "/operations/stopProcessing")
    public void stopProcessing() {
        processingStarted = false;
    }

    @RequestMapping(value = "/operations/isProcessingStarted")
    public boolean isProcessingStarted() {
        return processingStarted;
    }
}
