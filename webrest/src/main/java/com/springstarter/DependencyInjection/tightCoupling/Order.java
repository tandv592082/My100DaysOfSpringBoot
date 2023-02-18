package com.springstarter.DependencyInjection.tightCoupling;

public class Order {
    private int quantity;
    private Payment payment; //tight coupling

    public Order(int quantity, Payment payment) {
        this.quantity = quantity;
        this.payment = payment;
    }

    public void processOrder() {
        payment.pay(quantity);
    }

}
