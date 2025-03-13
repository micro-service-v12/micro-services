package org.example.Product;

import org.example.Product.Repository.ProductRepository;
import org.example.Product.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(null, "Laptop", 1200.00));
            productRepository.save(new Product(null, "Smartphone", 800.00));
            productRepository.save(new Product(null, "Tablet", 500.00));
            productRepository.findAll().forEach(System.out::println);
        };
    }
}