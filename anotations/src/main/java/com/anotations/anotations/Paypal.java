package com.anotations.anotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Paypal implements Payment{
    @Override
    public void pay() {
        System.out.println("You using paypal to pay for your payment");
    }
}
