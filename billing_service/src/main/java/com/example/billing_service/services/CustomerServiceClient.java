package com.example.billing_service.services;

import com.example.billing_service.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceClient {

    @GetMapping("/customers/{id} ")
    Customer findCustomerById(@PathVariable("id") Long id);
}
