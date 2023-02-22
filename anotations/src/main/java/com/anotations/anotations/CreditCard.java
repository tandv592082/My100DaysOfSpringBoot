package com.anotations.anotations;

import org.springframework.stereotype.Component;

// create new bean
@Component
public class CreditCard implements Payment {
    @Override
    public void pay() {
        System.out.println("You are using credit card to pay for yor order!");
    }
}
