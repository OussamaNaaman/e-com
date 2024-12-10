package com.example.billing_service.services;

import com.example.billing_service.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryServiceClient {

    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable Long id);

    @GetMapping("/products")
    PagedModel<Product> AllProducts();

}

