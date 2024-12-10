package org.example.customer_service.repositories;

import org.example.customer_service.entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<customer, Long> {
}
