package ru.gurv.vg.sample.account.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationProcessorTest {

    @Autowired
    private OperationProcessor processor;

    //TODO use MessageCollector
    @Test
    public void handle() {
        processor.handle("!!!");
    }
}