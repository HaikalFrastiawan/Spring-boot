package Haikal.spring.core;

import Haikal.spring.core.repository.CategoryRepository;
import Haikal.spring.core.repository.CustomerRepository;
import Haikal.spring.core.repository.ProductRepository;
import Haikal.spring.core.service.CategoriService;
import Haikal.spring.core.service.CustomerService;
import Haikal.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testService() {

        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService", ProductService.class);

        Assertions.assertSame(productService1, productService2);

    }

    @Test
    void testConstructorDependencyInjection(){
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository,productService.getProductRepository());
    }

    @Test
    void testSetterDependencyInjection() {
        CategoriService categoriService = applicationContext.getBean(CategoriService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryRepository, categoriService.getCategoryRepository());
    }

    @Test
    void testFieldDI() {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository",CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository",CustomerRepository.class);

        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }
}
