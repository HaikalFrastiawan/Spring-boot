package Haikal.spring.core;

import Haikal.spring.core.data.Bar;
import Haikal.spring.core.data.Foo;
import Haikal.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class OpsionalConfiguration {

    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo>foo, Optional<Bar>bar){
        return new FooBar(foo.orElse(null),bar.orElse(null));
    }



}
