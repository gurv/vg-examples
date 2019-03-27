package ru.gurv.vg.sample.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
@EnableSwagger2
public class OperationSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationSampleApplication.class, args);
    }
}
