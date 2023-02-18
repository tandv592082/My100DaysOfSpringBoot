package com.springstarter.DependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springstarter.DependencyInjection.looselyCoupled.CreditPayment;
import com.springstarter.DependencyInjection.looselyCoupled.PaypalPayment;
import com.springstarter.DependencyInjection.looselyCoupled.Order;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

        PaypalPayment paypal = new PaypalPayment();
        CreditPayment credit = new CreditPayment();

        Order order = new Order(0, paypal);
        order.processOrder();
        order.setPayment(credit);
        order.processOrder();
	}

}
