package Haikal.spring.core;

import Haikal.spring.core.data.cyclic.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void tearDown() {
    //applicationContext.close(); manual
    }

    @Test
    void testConnection() {
        Connection connection = applicationContext.getBean(Connection.class);
    }
}
