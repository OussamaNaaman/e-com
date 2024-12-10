package org.example.inventory_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct", types = Product.class)
public interface FullProductProjection {
    Long getId();
    String getName();
    Double getPrice();
}