package Haikal.spring.core;

import Haikal.spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "Haikal.spring.core.repository",
        "Haikal.spring.core.service",
        "Haikal.spring.core.configuration",
})

@Import(MultiFoo.class)

public class ComponentConfiguration {

}
