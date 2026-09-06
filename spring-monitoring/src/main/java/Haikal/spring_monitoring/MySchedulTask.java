package Haikal.spring_monitoring;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MySchedulTask {
    @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
    public void hello(){
        System.out.println("Hello World");
    }
}
