package Haikal.spring.core;

import Haikal.spring.core.Application.FooAplication;
import Haikal.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FooAplication.class)
public class FooAplicationTest {

   @Autowired
   Foo foo;

   @Test
   void testSpringboot() {
      Assertions.assertNotNull(foo);
   }
}
