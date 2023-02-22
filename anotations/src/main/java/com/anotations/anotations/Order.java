package com.anotations.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {
    @Autowired
    Payment payment;

    public Order() {

    }

    public Order(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void payOrder() {
        payment.pay();
    }
}
