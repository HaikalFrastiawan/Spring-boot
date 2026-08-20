package Haikal.spring.core.Application;


import Haikal.spring.core.Listener.AppStartingListener;
import Haikal.spring.core.data.Foo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FooAplication {

    @Bean
    public Foo foo(){
        return new Foo();
    }

    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooAplication.class, args);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);

        SpringApplication application = new SpringApplication(FooAplication.class);
        application.setListeners(List.of(new AppStartingListener()));
        ConfigurableApplicationContext applicationContext = application.run(args);

         Foo foo = applicationContext.getBean(Foo.class);
         System.out.println(foo);
    }
}
