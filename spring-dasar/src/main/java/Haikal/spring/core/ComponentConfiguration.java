package Haikal.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "Haikal.spring.core.repository",
        "Haikal.spring.core.service",
})

public class ComponentConfiguration {

}
