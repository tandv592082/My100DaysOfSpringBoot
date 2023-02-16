package com.springstarter.webrest.database;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springstarter.webrest.models.Product;
import com.springstarter.webrest.repositories.ProductRepository;

@Configuration
public class Database {
    private static final Logger logger = LogManager.getLogger(Database.class);


    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception { 
                Product productA = new Product("Samsung S23 Ultra", 2023, 2600000, "");
                Product productB = new Product("Note 10 Plus", 2020, 13000000, "");
                logger.info("Insert data: " + productRepository.save(productA));
                logger.info("Insert datat: " + productRepository.save(productB));
            }
        };
    }
}
