package org.example.controllers;

import org.example.clients.CustomerClient;
import org.example.clients.ProductClient;
import org.example.dtos.Customer;
import org.example.dtos.Order;
import org.example.dtos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public OrderController(CustomerClient customerClient, ProductClient productClient) {
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    @GetMapping("/{customerId}/{productId}")
    public Order placeOrder(@PathVariable("customerId") Long customerId,
                            @PathVariable("productId") Long productId) {

        Customer customer = customerClient.getCustomerById(customerId);
        Product product = productClient.getProductById(productId);

        // Création d'une commande avec l'id client, l'id produit et le prix du produit comme total
        return new org.example.dtos.Order(customer.getId(), product.getId(), product.getPrice());
    }
}

