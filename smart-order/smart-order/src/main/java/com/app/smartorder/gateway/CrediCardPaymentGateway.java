package com.app.smartorder.gateway;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("creditcard")
public class CrediCardPaymentGateway implements PaymentGateway {
    @Override
    public boolean proccessPayment(String orderId, BigDecimal amount) {
        System.out.println("💳 [Credit Card] Memproses verifikasi kartu kredit order " + orderId + " sebesar Rp" + amount);
        return true;
    }

    @Override
    public String getGatewayName() {
        return "Credit Card";
    }
}
