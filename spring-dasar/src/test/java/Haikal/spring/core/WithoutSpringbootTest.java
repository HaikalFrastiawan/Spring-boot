package Haikal.spring.core;

import Haikal.spring.core.Application.FooAplication;
import Haikal.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithoutSpringbootTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FooAplication.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFoo() {
        Foo foo = applicationContext.getBean(Foo.class);

    }
}
