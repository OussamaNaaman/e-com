package org.example.customer_service;

import lombok.Builder;
//import org.example.customer_service.config.CustomerConfiguration;
import org.example.customer_service.entities.customer;
import org.example.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication @Builder
//@EnableConfigurationProperties(CustomerConfiguration.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            RepositoryRestConfiguration restConfiguration){ {
        return args -> {
            restConfiguration.exposeIdsFor(customer.class);
            customerRepository.saveAll(
                    List.of(
            customerRepository.save(new customer(null, "Hassan", "hassan@hassan")),
            customerRepository.save(new customer(null, "Abdelrahman", "abdelrahman@abdelrahman")),
            customerRepository.save(new customer(null, "Ahmed", "ahmed@ahmed")),
            customerRepository.save(new customer(null, "Sayed", "sayed@sayed")),
            customerRepository.save(new customer(null, "Bassma", "Bassma@ZIna"))


                    )
            );
            customerRepository.findAll().forEach(System.out::println);



        };

    }
}
}
