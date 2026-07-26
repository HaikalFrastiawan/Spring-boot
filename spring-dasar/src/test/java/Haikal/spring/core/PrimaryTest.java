package Haikal.spring.core;

import Haikal.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {

    private ApplicationContext aplicationContext;

    @BeforeEach
    void setUp() {
        aplicationContext = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);

    }

    @Test
    void testGetPrimary(){
        Foo foo = aplicationContext.getBean(Foo.class);
        Foo foo1 =aplicationContext.getBean("foo1", Foo.class);
        Foo foo2 =aplicationContext.getBean("foo2", Foo.class);

        Assertions.assertSame(foo,foo1);
        Assertions.assertNotSame(foo,foo2);
        Assertions.assertNotSame(foo1,foo2);
    }
}
