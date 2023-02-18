package com.springstarter.DependencyInjection.looselyCoupled;

/**
 * DI = DependencyInjection
 */

public class Order {
    private int quantity;
    private Payment payment;

    

    // DI: Inject dependencies via contructor   
    public Order(int quantity, Payment payment) {
        this.quantity = quantity;
        this.payment = payment;
    }

    //DI: Inject dependencies via setter
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void processOrder() {
        payment.pay(quantity);
    }
}

