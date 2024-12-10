package com.example.billing_service;

import com.example.billing_service.entities.Bill;
import com.example.billing_service.entities.Customer;
import com.example.billing_service.entities.Product;
import com.example.billing_service.entities.ProductItem;
import com.example.billing_service.repositories.BillRepository;
import com.example.billing_service.repositories.ProductItemRepository;
import com.example.billing_service.services.CustomerServiceClient;
import com.example.billing_service.services.InventoryServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerServiceClient customerServiceClient,
							InventoryServiceClient inventoryServiceClient) {
		return args -> {
			Collection<Product> products = inventoryServiceClient.AllProducts().getContent();
			long customerID = customerServiceClient.findCustomerById(1L).getId();
			Bill bill = new Bill();
			bill.setBillingDate(new Date());
			bill.setCustomerID(customerID);
			Bill savedBill = billRepository.save(bill);
			products.forEach(p->{
				ProductItem productItem = new ProductItem();
				productItem.setBill(savedBill);
				productItem.setProductID(p.getId());
				productItem.setPrice(p.getPrice());
				productItem.setQuantity(1+Math.random());
				productItemRepository.save(productItem);
			});

		};
	}
}
