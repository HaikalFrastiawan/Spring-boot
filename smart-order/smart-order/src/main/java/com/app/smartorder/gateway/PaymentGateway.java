package com.app.smartorder.gateway;

import java.math.BigDecimal;

public interface PaymentGateway {
    boolean proccessPayment(String orderId, BigDecimal amount);
    String getGatewayName();
}
