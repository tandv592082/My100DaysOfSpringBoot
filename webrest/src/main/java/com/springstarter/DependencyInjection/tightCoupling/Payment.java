package com.springstarter.DependencyInjection.tightCoupling;

public class Payment {
    public void pay(int quantity) {
        System.out.println("Payment for: " + quantity + "order");
    }
}
