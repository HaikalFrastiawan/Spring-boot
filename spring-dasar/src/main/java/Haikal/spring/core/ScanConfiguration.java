package Haikal.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {
        "Haikal.spring.core.configuration"
})
public class ScanConfiguration {
}
