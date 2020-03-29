package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <a href="https://spring.io/guides/gs/scheduling-tasks/">Scheduling Tasks</a>
 */
@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApp {
    public static void main(String[] args) {
        SpringApplication.run(SchedulingTasksApp.class, args);
    }
}
