package Haikal.spring.core;

import Haikal.spring.core.service.MerchantService;
import Haikal.spring.core.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class InheritenceTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(InheritenceConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testInheritence() {
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImpl merchantService1 = applicationContext.getBean(MerchantServiceImpl.class);

        Assertions.assertSame(merchantService,merchantService1);

    }
}
