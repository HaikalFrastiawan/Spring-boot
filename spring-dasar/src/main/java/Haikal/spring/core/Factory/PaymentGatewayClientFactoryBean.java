package Haikal.spring.core.Factory;

import Haikal.spring.core.Client.PaymentGatewayClient;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("paymentGatewayClient")
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient>{
    @Override
    public @Nullable PaymentGatewayClient getObject() throws Exception {

        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndpoint("http://example.com");
        client.setPrivateKey("private");
        client.setPublicKey("public");
        return client;
    }

    @Override
    public @Nullable Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
