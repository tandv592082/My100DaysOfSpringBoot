package com.springstarter.DependencyInjection.DI;

public class PaypalPayment implements Payment {
    public void pay(int quantity) {
        System.out.println("You using Paypal for payment method");
    }
}
