package Haikal.spring.core;

import Haikal.spring.core.data.Server;
import Haikal.spring.core.data.cyclic.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {
    @Bean
    public Connection connection(){
        return new Connection();
    }

//    @Bean(initMethod = "Start",destroyMethod = "Stop")
    @Bean
    public Server server(){
        return new Server();
    }
}
