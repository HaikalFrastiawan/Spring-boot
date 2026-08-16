package Haikal.spring.core;

import Haikal.spring.core.Client.PaymentGatewayClient;
import Haikal.spring.core.Factory.PaymentGatewayClientFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PaymentGatewayClientFactoryBean.class
})
public class FactoryConfiguration {
}
