package org.example.inventory_service;

import org.example.inventory_service.entities.Product;
import org.example.inventory_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);

    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            RepositoryRestConfiguration restConfiguration){

        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.save(new Product(null,"Computer Desk Top HP",900.0));
            productRepository.save(new Product(null,"Printer Epson",80.0));
            productRepository.save(new Product(null,"MacBook Pro Lap Top",1800.0));
            productRepository.findAll().forEach(System.out::println);

        };

    }

}
