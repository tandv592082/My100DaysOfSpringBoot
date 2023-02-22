package com.anotations.anotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // main runner
public class App {

	public static void main(String[] args) {
		/**
		 * Create IoC container
		 */
	 ConfigurableApplicationContext context	= SpringApplication.run(App.class, args);

	  Payment payment = context.getBean(Payment.class);
	  System.out.println(payment);
	  payment.pay();

	  Order order = context.getBean(Order.class);
	  System.out.println(order.payment);
	  order.payment.pay();
	}

}
