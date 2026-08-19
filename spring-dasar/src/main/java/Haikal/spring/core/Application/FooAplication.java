package Haikal.spring.core.Application;


import Haikal.spring.core.data.Foo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FooAplication {

    @Bean
    public Foo foo(){
        return new Foo();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooAplication.class, args);

        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);
    }
}
