package com.springstarter.DependencyInjection.DI;

public class CreditPayment implements Payment {
    public void pay(int quantity) {
        System.out.println("You using credit for payment method");
    }
}
