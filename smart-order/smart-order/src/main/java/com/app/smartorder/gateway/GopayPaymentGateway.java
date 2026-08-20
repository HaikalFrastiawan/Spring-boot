package com.app.smartorder.gateway;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Primary
public class GopayPaymentGateway implements PaymentGateway {
    @Override
    public boolean proccessPayment(String orderId, BigDecimal amount) {
        System.out.println("💳 [GoPay] Memproses pembayaran order " + orderId + " sebesar Rp" + amount);
        return true;
    }

    @Override
    public String getGatewayName() {
        return "Gopay";
    }
}
